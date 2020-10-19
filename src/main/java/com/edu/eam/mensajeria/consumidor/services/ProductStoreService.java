package com.edu.eam.mensajeria.consumidor.services;

import com.edu.eam.mensajeria.consumidor.exceptions.BusinessException;
import com.edu.eam.mensajeria.consumidor.exceptions.NotFoundException;
import com.edu.eam.mensajeria.consumidor.models.entities.Product;
import com.edu.eam.mensajeria.consumidor.models.entities.ProductStore;
import com.edu.eam.mensajeria.consumidor.repositories.ProductStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductStoreService {

    @Autowired
    private ProductStoreRepository productStoreRepository;

    public void create(ProductStore ps){
        boolean productStore = productStoreRepository.existsById(ps.getProductId());
        if(productStore)
            throw new BusinessException("Ya existe un productStore con el ID: "+ps.getProductId(), "productStore_exist");

        productStoreRepository.save(ps);
    }
}
