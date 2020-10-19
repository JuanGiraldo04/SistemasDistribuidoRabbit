package com.edu.eam.mensajeria.consumidor.producers;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventarioErrorProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    public void produceErrorInventario(String message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "inventario_error", message);
    }

}
