package com.asg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asg.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
