package com.amediavilla.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amediavilla.spring.model.vehicles.AbstractProduct;

@Repository
public interface ProductRepository extends JpaRepository<AbstractProduct, Long>{

}
