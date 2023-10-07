package com.turkcell.spring.starter.business.abstracts;

import com.turkcell.spring.starter.entities.Order;
import com.turkcell.spring.starter.entities.OrderDetail;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.orderDto.OrderForAddDto2;
import com.turkcell.spring.starter.entities.dtos.orderDto.OrderForGetById;
import com.turkcell.spring.starter.entities.dtos.orderDto.OrderForListingDto;
import com.turkcell.spring.starter.entities.dtos.orderDto.OrderForUpdateDto;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order addOrder(Order order);
    Order getByOrderId(long OrderId);
    void deleteByOrderId(long deleteByOrderId);

    List<OrderForListingDto> orderListing();
    OrderForGetById orderId(int orderId);

    Order updateOrder(int id, OrderForUpdateDto orderForUpdateDto);

//    void addOrderDto(OrderForAddDto orderForUpdateDto);

    List<OrderDetail> addOrderDetails (int id, Product product);
    List<Object[]> getOrderProductName();
    void add(OrderForAddDto2 request);



}
