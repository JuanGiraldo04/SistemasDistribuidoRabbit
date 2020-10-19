package com.edu.eam.mensajeria.consumidor.services;

import com.edu.eam.mensajeria.consumidor.exceptions.BusinessException;
import com.edu.eam.mensajeria.consumidor.models.entities.ProductStore;
import com.edu.eam.mensajeria.consumidor.models.entities.Store;
import com.edu.eam.mensajeria.consumidor.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Boolean create(Store s){
        boolean store = storeRepository.existsById(s.getStoreId());
        if(store)
            return false;

        storeRepository.save(s);
        return true;
    }

    public Store find(Integer id){
        return storeRepository.findById(id).get();
    }
}
