package com.turkcell.spring.starter.business.concrets;

import com.turkcell.spring.starter.business.abstracts.CategoryService;
import com.turkcell.spring.starter.business.exception.BusinessException;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.categoryDto.CategoryForAddDto;
import com.turkcell.spring.starter.entities.dtos.categoryDto.CategoryForListingDto;
import com.turkcell.spring.starter.entities.dtos.categoryDto.CategoryForUpdateDto;
import com.turkcell.spring.starter.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryServiceImp implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }




    @Override
    public Category addCategory(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public Category getByCategoryId(int categoryId) {
        return categoryRepository.findById(categoryId).get();
    }




    @Override
    public List<Category> findByCategoryNameContaining(String categoryName) {
        return categoryRepository.findByCategoryNameContaining(categoryName);
    }

    @Override
    public List<Category> search(String categoryName) {
        return categoryRepository.search(categoryName);
    }

    @Override
    public Long countCategory() {
        return categoryRepository.countCategory();
    }

    @Override
    public List<Category> getById(int id) {
        return categoryRepository.getById(id);
    }

    @Override
    public List<Object[]> findCategoryAndProductDetails() {
        return categoryRepository.findCategoryAndProductDetails();
    }

    @Override
    public void add(CategoryForAddDto request) {
        // Business Rule => Aynı isimde iki kategori olmamalı

//        descriptionWithSameNameShouldNotExist(request.getDescription());
//        categoryWithSameNameShouldNotExist(request.getCategoryName());
//        descriptionShouldNotMoreThan2Char(request.getDescription());
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());

        // Mapleme işlemi business içerisinde
        categoryRepository.save(category);
    }

    @Override
    public Category updateDto( CategoryForUpdateDto categoryForUpdateDto) {
       Category category=returnCategoryByIdExist(categoryForUpdateDto.getCategoryId());
        category.setCategoryName(categoryForUpdateDto.getCategoryName());
        category.setDescription(categoryForUpdateDto.getDescription());
        return categoryRepository.save(category);
    }
    @Override
    public List<CategoryForListingDto> getAll() {
//        List<Category> categories=categoryRepository.findAll();
//        List<CategoryForListingDto> categoryForListingDtos=new ArrayList<>();
//        for(Category c: categories){
//            CategoryForListingDto dto=new CategoryForListingDto();
//            dto.setCategoryId(c.getCategoryId());
//            dto.setCategoryName(c.getCategoryName());
//            categoryForListingDtos.add(dto);
//        }
        return categoryRepository.getForListing();
    }
    @Override
    public void deleteByCategoryId(int deleteId) {

        Category categoryToDelete=returnCategoryByIdExist(deleteId);


        categoryRepository.delete(categoryToDelete);

    }
    public Category returnCategoryByIdExist(int id){
        Category categoryToDelete= categoryRepository.findById(id).orElse(null);
        if (categoryToDelete==null)
            throw new BusinessException("Böyle bir kategori bulunamadı");
        return categoryToDelete;

    }


    private void categoryWithSameNameShouldNotExist(String categoryName) {
        Category categoryWithSameName = categoryRepository.findByCategoryName(categoryName);
        if (categoryWithSameName != null) {
            throw new BusinessException("Aynı kategori isminden 2 kategori bulunamaz.");
        }
    }

    public void descriptionShouldNotMoreThan2Char(String description) {
        if (description.length() < 2) {
            throw new BusinessException("Açıklama kısmı 2 harften az olamaz.");
        }
    }

    private void descriptionWithSameNameShouldNotExist(String description) {
        Category categoryWithSameName = categoryRepository.findByCategoryName(description);
        if (description != null) {
            throw new BusinessException("Aynı açıklamadan 2 tane bulunamaz.");
        }
    }
}




