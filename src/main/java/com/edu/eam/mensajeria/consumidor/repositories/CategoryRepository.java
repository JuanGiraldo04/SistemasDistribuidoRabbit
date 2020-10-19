package com.edu.eam.mensajeria.consumidor.repositories;

import com.edu.eam.mensajeria.consumidor.models.entities.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c where LOWER(c.categoryName) like LOWER(:name)")
    Category findByName(String name);
}
