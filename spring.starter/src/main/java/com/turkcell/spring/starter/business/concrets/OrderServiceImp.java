package com.turkcell.spring.starter.business.concrets;

import com.turkcell.spring.starter.business.abstracts.OrderService;
import com.turkcell.spring.starter.business.exception.BusinessException;
import com.turkcell.spring.starter.entities.Order;
import com.turkcell.spring.starter.entities.dtos.OrderForAddDto;
import com.turkcell.spring.starter.entities.dtos.OrderForGetById;
import com.turkcell.spring.starter.entities.dtos.OrderForListingDto;
import com.turkcell.spring.starter.entities.dtos.OrderForUpdateDto;
import com.turkcell.spring.starter.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImp implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getByOrderId(long OrderId) {
        return orderRepository.findById((int) OrderId).get();

    }

    @Override
    public void deleteByOrderId(long deleteByOrderId) {
        orderRepository.deleteById((int) deleteByOrderId);

    }

    @Override
    public List<OrderForListingDto> orderListing() {
      return orderRepository.getOrder();
    }

    @Override
    public List<OrderForGetById> orderId(int orderId) {
        return orderRepository.orderId(orderId);
    }

    @Override
    public Order updateOrder(int id, OrderForUpdateDto request) {
        Order order=orderRepository.findById(id).orElseThrow();
        order.setOrderId(request.getOrderId());
        order.setOrderDate(request.getOrderDate());
        order.setRequiredDate(request.getRequiredDate());
        order.setShippedDate(request.getShippedDate());
        order.setShippedDate(request.getShippedDate());
        order.setFreight(request.getFreight());
        return orderRepository.save(order);
    }

    @Override
    public void addOrderDto(OrderForAddDto orderForUpdateDto) {
        orderIdShouldNotMoreThan13000(orderForUpdateDto.getOrderId());
        shippedDateShouldNotBeMoreThan10Char(orderForUpdateDto.getShippedDate());
        freightShouldBeLessThan7Char(orderForUpdateDto.getFreight());
      Order order=new Order();
      order.setOrderId(orderForUpdateDto.getOrderId());
      order.setOrderDate(orderForUpdateDto.getOrderDate());
      order.setRequiredDate(orderForUpdateDto.getRequiredDate());
      order.setShippedDate(orderForUpdateDto.getShippedDate());
      order.setShipVia(orderForUpdateDto.getShipVia());
      order.setFreight(orderForUpdateDto.getFreight());
      orderRepository.save(order);
    }
    public void orderIdShouldNotMoreThan13000(int orderId){
        if(orderId>13000){
            throw new BusinessException("Ürün Id'si 13000'den büyük olamaz.");
        }
    }
    public void shippedDateShouldNotBeMoreThan10Char(String shippedDate){
        if (shippedDate.length()>10){
            throw  new BusinessException("Lütfen geçerli bir tarih giriniz.");
        }
    }
    public void freightShouldBeLessThan7Char(String freight){
        if (freight.length()>7){
            throw new BusinessException("Belirtilen Freight alanı kurallara göre fazla");
        }
    }


}
