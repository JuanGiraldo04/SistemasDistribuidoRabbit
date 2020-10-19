package com.edu.eam.mensajeria.consumidor.services;

import com.edu.eam.mensajeria.consumidor.exceptions.BusinessException;
import com.edu.eam.mensajeria.consumidor.exceptions.NotFoundException;
import com.edu.eam.mensajeria.consumidor.models.entities.Category;
import com.edu.eam.mensajeria.consumidor.models.entities.Product;
import com.edu.eam.mensajeria.consumidor.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void create(Category c){
        Category category = categoryRepository.findByName("%"+c.getCategoryName()+"%");
        if(category!=null)
            throw new BusinessException("Ya existe una category con el nombre: "+c.getCategoryName(), "category_exist");

        categoryRepository.save(c);
    }

    public Category find(String name){
        return categoryRepository.findByName(name);
    }
}
