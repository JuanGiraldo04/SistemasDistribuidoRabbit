package com.edu.eam.mensajeria.consumidor.services;

import com.edu.eam.mensajeria.consumidor.exceptions.BusinessException;
import com.edu.eam.mensajeria.consumidor.exceptions.NotFoundException;
import com.edu.eam.mensajeria.consumidor.models.entities.Product;
import com.edu.eam.mensajeria.consumidor.repositories.CategoryRepository;
import com.edu.eam.mensajeria.consumidor.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void create(Product p){
        boolean product = productRepository.existsById(p.getProductId());
        if(product)
            throw new BusinessException("Ya existe un producto con el ID: "+p.getProductId(), "product_exist");


        boolean category = categoryRepository.existsById(p.getCategoryId());
        if(!category)
            throw new NotFoundException("No existe una categoria con el ID: "+p.getCategoryId(), "categoryFK_doesnt_exist");

        productRepository.save(p);
    }
}
