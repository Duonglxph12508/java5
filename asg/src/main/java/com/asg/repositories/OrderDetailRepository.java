package com.asg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asg.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
