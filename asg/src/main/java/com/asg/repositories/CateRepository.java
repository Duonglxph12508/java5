package com.asg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asg.entity.Categories;

@Repository
public interface CateRepository extends JpaRepository<Categories, Integer> {

}
