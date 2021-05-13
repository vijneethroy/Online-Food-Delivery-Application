package com.cg.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fooddelivery.entities.Category;


public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
