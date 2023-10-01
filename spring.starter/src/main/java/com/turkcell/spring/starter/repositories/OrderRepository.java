package com.turkcell.spring.starter.repositories;

import com.turkcell.spring.starter.entities.Order;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.OrderForGetById;
import com.turkcell.spring.starter.entities.dtos.OrderForListingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(value = "select new " +
            "com.turkcell.spring.starter.entities.dtos.OrderForListingDto" +
            "(o.orderId,o.orderDate, o.requiredDate, o.shippedDate, o.shipVia, o.freight)" +
            "from Order o")
    List<OrderForListingDto> getOrder();

    @Query(value = "select new " +
            "com.turkcell.spring.starter.entities.dtos.OrderForGetById" +
            "(o.orderId,o.orderDate, o.requiredDate, o.shippedDate, o.shipVia, o.freight)" +
            "from Order o where o.orderId= :orderId")

    List<OrderForGetById> orderId( int orderId);
}
