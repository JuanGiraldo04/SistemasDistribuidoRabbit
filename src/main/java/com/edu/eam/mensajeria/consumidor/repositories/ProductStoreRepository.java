package com.edu.eam.mensajeria.consumidor.repositories;

import com.edu.eam.mensajeria.consumidor.models.entities.ProductStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStoreRepository extends JpaRepository<ProductStore, Integer> {
}
