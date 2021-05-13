package com.cg.fooddelivery.repository;

 


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.fooddelivery.entities.Customer;
import com.cg.fooddelivery.entities.Item;
import com.cg.fooddelivery.entities.Restaurant;


@Repository
public interface IItemRepository extends JpaRepository<Item, Integer>{


}