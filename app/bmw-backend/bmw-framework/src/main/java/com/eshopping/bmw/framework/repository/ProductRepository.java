package com.eshopping.bmw.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshopping.bmw.framework.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
