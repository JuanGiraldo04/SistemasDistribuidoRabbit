package com.edu.eam.mensajeria.consumidor.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

  @Bean
  public Queue inventarioQueue(){
    return new Queue("inventarioQueue", true);
  }

  @Bean
  public Queue inventarioErrorQueue(){
    return new Queue("inventarioErrorQueue", true);
  }

  @Bean
  public DirectExchange directExchange(){
    return new DirectExchange("direct_exchange");
  }

  @Bean
  public Binding bindDirectExchangeInventarioQueue(Queue inventarioQueue, DirectExchange directExchange){
    return BindingBuilder.bind(inventarioQueue).to(directExchange).with("inventario");
  }

  @Bean
  public Binding bindDirectExchangeInventarioErrorQueue(Queue inventarioErrorQueue, DirectExchange directExchange){
    return BindingBuilder.bind(inventarioErrorQueue).to(directExchange).with("inventario_error");
  }

}
