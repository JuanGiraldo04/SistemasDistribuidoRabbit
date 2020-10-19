package com.edu.eam.mensajeria.consumidor.repositories;

import com.edu.eam.mensajeria.consumidor.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
