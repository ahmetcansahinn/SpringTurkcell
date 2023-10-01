package com.turkcell.spring.starter.business.concrets;

import com.turkcell.spring.starter.business.abstracts.ProductService;
import com.turkcell.spring.starter.business.exception.BusinessException;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.ProductForAddDto;
import com.turkcell.spring.starter.entities.dtos.ProductForGetByIdDto;
import com.turkcell.spring.starter.entities.dtos.ProductForListingDto;
import com.turkcell.spring.starter.entities.dtos.ProductForUpdateDto;
import com.turkcell.spring.starter.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class ProductServiceImp implements ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    public List<ProductForListingDto> getAll() {
        return productRepository.getListingProduct();
    }

    public Product getProductById(int productId){
        return productRepository.findById(productId).get();
    }
    public void deleteProductById(int productId){
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> findByProductNameContaining(String productName) {
        return productRepository.findByProductNameContaining(productName);
    }

    @Override
    public List<Product> search(String productName) {
        return productRepository.search(productName);
    }

    @Override
    public List<Product> searchNative(String productName) {
        return productRepository.searchNative(productName);
    }



    @Override
    public List<String> findProductNames() {
        return productRepository.findProductNames();
    }

    @Override
    public List<Integer> findProductId() {
        return productRepository.findProductId();
    }

    @Override
    public List<Product> topCheapest(Integer topNumber) {
        return productRepository.topCheapest(topNumber);
    }

    @Override
    public List<Product> pcGet(int id) {
        return productRepository.pcGet(id);
    }

    @Override
    public List<Product> maxAndMin() {
        return productRepository.maxAndMin();
    }

    @Override
    public List<Product> minManUnit(Integer minUnit, Integer maxUnit) {
        return productRepository.minManUnit(minUnit, maxUnit);
    }

    @Override
    public List<Product> chaiUnit(double unitPrice) {
        return productRepository.chaiUnit(unitPrice);
    }

    @Override
    public Double maxUnitPrice() {
        return productRepository.maxUnitPrice();
    }

    @Override
    public List<Product> groupById() {
        return productRepository.groupById();
    }

    @Override
    public List<ProductForGetByIdDto> getListingProductId(int id) {


        return productRepository.getListingProductId(id);
    }

    @Override
    public Product update(int id, ProductForUpdateDto productForUpdateDto) {

        Product product = productRepository.findById(id).orElseThrow();
//        Product product = new Product();
        product.setProductName(productForUpdateDto.getProductName());
        product.setUnitPrice(productForUpdateDto.getUnitPrice());
        product.setUnitInStock(productForUpdateDto.getUnitInStock());
        product.setUnitOnOrder(productForUpdateDto.getUnitOnOrder());
        product.setQuantityPerUnit(productForUpdateDto.getQuantityPerUnit());
        product.setReorderLevel(productForUpdateDto.getReorderLevel());
        product.setDiscontinued(0);
        return productRepository.save(product);
    }

    @Override
    public void add(ProductForAddDto request) {
        productNameShouldNotLongerThanTwoCharacters(request.getProductName());
        unitPricekShouldNotBeBiggerThan200(request.getUnitPrice());
        productNameIsChangShouldNotAddNow(request.getProductName());
        Product product=new Product();
//        product.setProductId();
        product.setProductName(request.getProductName());
        product.setUnitPrice(request.getUnitPrice());
        product.setUnitInStock(request.getUnitInStock());
        product.setQuantityPerUnit(request.getQuantityPerUnit());
        product.setReorderLevel(request.getReOrderLevel());
        productRepository.save(product);
    }


    private void productNameShouldNotLongerThanTwoCharacters(String productName){

        if(productName.length()<=2){
            throw new BusinessException("Ürün ismi 2 harften fazla olmalıdır ");
        }
    }
    public void unitPricekShouldNotBeBiggerThan200(double unitPrice){
        if(unitPrice>50){
            throw new BusinessException("Ürün fiyatı 50'den büyük olamaz.");
        }
    }
    public void productNameIsChangShouldNotAddNow(String productName){
        if(productName.equals("Chang")){
            throw new BusinessException("Chang isimli ürün şu an için kaydedilemiyor.");
        }
    }







}
