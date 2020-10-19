package com.edu.eam.mensajeria.consumidor.consumers;

import com.edu.eam.mensajeria.consumidor.exceptions.BusinessException;
import com.edu.eam.mensajeria.consumidor.models.entities.Category;
import com.edu.eam.mensajeria.consumidor.models.entities.Product;
import com.edu.eam.mensajeria.consumidor.models.entities.ProductStore;
import com.edu.eam.mensajeria.consumidor.models.entities.Store;
import com.edu.eam.mensajeria.consumidor.producers.InventarioErrorProducer;
import com.edu.eam.mensajeria.consumidor.services.CategoryService;
import com.edu.eam.mensajeria.consumidor.services.ProductService;
import com.edu.eam.mensajeria.consumidor.services.ProductStoreService;
import com.edu.eam.mensajeria.consumidor.services.StoreService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductStoreService productStoreService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private InventarioErrorProducer inventarioErrorProducer;

    @RabbitListener(queues = "#{inventarioQueue.name}")
    public void listenInventarioQueue(String mensaje){

        try{
            String campos[] = mensaje.split(",");
            Integer product_id = Integer.parseInt(campos[0]);
            String product_name = campos[1];
            String product_price = campos[2];
            String category_name = campos[3];
            Integer store_id = Integer.parseInt(campos[5]);
            String store_name = campos[6];

            Category category = categoryService.find(category_name);
            if(category == null){
                categoryService.create(new Category(category_name));
                category = categoryService.find(category_name);
            }

            productService.create(new Product(product_id, product_name, category.getCategoryId()));

            storeService.create(new Store(store_id, store_name));

            productStoreService.create(new ProductStore(product_id, product_price, store_id));

        }catch (BusinessException businessException){
            inventarioErrorProducer.produceErrorInventario(mensaje);
        }

    }
}
