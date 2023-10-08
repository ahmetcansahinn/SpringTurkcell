package com.turkcell.spring.starter.business.concrets;

import com.turkcell.spring.starter.business.abstracts.OrderDetailService;
import com.turkcell.spring.starter.business.abstracts.OrderService;
import com.turkcell.spring.starter.business.exception.BusinessException;
import com.turkcell.spring.starter.entities.*;
import com.turkcell.spring.starter.entities.dtos.orderDto.OrderForAddDto2;
import com.turkcell.spring.starter.entities.dtos.orderDto.OrderForGetById;
import com.turkcell.spring.starter.entities.dtos.orderDto.OrderForListingDto;
import com.turkcell.spring.starter.entities.dtos.orderDto.OrderForUpdateDto;
import com.turkcell.spring.starter.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class OrderServiceImp implements OrderService {

    private OrderRepository orderRepository;
    private OrderDetailService orderDetailService;

    public OrderServiceImp(OrderRepository orderRepository, OrderDetailService orderDetailService) {
        this.orderRepository = orderRepository;
        this.orderDetailService = orderDetailService;
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
    public OrderForGetById orderId(int orderId) {
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
    @Transactional
    public void add(OrderForAddDto2 request) {
        Order order=Order.builder().
                customers(Customer.builder().customerId(request.getCustomerId()).build())
                .orderDate(LocalDate.now())
                .employees(Employee.builder().employeeId(request.getEmployeeId()).build())
                .requiredDate(request.getRequiredDate())
                .shipAddress(request.getShipAddress())
                .shipCity(request.getShipCity())
                .shipName(request.getShipName())
                .shipRegion(request.getShipRegion())
                .build();
        order = orderRepository.save(order);
//        throw new BusinessException(".");
        orderDetailService.addItemsToOrder(order, request.getItems());
    }

//    @Override
//    public void addOrderDto(OrderForAddDto orderAddDto) {
////        customerIdIsNotFound(orderAddDto.getCustomerId());
//
//        orderIdShouldNotMoreThan13000(orderAddDto.getOrderId());
//        shippedDateShouldNotBeMoreThan10Char(orderAddDto.getShippedDate());
//        freightShouldBeLessThan7Char(orderAddDto.getFreight());
//      Order order=new Order();
//        LocalDate localdate=LocalDate.now();
//
//        if (localdate.compareTo(LocalDate.parse(orderAddDto.getRequiredDate()))>0) {
//            throw new BusinessException("Lütfen geçmiş bir tarih girmeyin");
//        } else {
//            order.setRequiredDate(orderAddDto.getRequiredDate());
//        }
////      order.setCustomerId(orderAddDto.getCustomerId());
//        OrderForAddDto orderForAddDto=new OrderForAddDto();
//      order.setOrderId(orderAddDto.getOrderId());
//      order.setOrderDate(String.valueOf(localdate));
//      order.setRequiredDate(String.valueOf(localdate));
//      order.setShippedDate(orderAddDto.getShippedDate());
//      order.setShipVia(orderAddDto.getShipVia());
//      order.setFreight(orderAddDto.getFreight());
////      orderForAddDto.setEmployeeId(orderAddDto.getEmployeeId());
//
//      orderRepository.save(order);
//    }

    @Override
    public List<OrderDetail> addOrderDetails(int id, Product product) {
        return orderRepository.addOrderDetails(id, product);
    }

    @Override
    public List<Object[]> getOrderProductName() {
        return orderRepository.getOrderProductName();
    }


    public void orderIdShouldNotMoreThan13000(int orderId){
        if(orderId>13000){
            throw new BusinessException("Ürün Id'si 13000'den büyük olamaz.");
        }
    }
//    public void shippedDateShouldNotBeMoreThan10Char(String shippedDate){
//        if (shippedDate.length()>10){
//            throw  new BusinessException("Lütfen geçerli bir tarih giriniz.");
//        }
//    }
    public void freightShouldBeLessThan7Char(String freight){
        if (freight.length()>7){
            throw new BusinessException("Belirtilen Freight alanı kurallara göre fazla");
        }
    }
    public void customerIdIsNotFound(String customerId){
        if(customerId.isEmpty()){
            throw new BusinessException("Yazılan id'ye ait bir customer bulunmamaktadır.");
        }
    }





}
