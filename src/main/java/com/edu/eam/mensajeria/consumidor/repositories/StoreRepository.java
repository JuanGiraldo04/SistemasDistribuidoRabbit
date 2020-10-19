package com.edu.eam.mensajeria.consumidor.repositories;

import com.edu.eam.mensajeria.consumidor.models.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
