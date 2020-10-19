package com.edu.eam.mensajeria.consumidor.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "product_stores")
public class ProductStore implements Serializable {

    @Id
    @Column(name = "product_id")
    private Integer productId;

    @NotBlank(message = "El precio del producto es obligatorio")
    @NotEmpty(message = "El precio del producto es obligatorio")
    @NotNull(message = "El precio del producto es obligatorio")
    @Column(name = "product_price")
    private String productPrice;


    @Column(name = "store_id")
    private Integer storeId;

    public ProductStore() {
    }

    public ProductStore(Integer productId, @NotBlank @NotEmpty @NotNull String productPrice, Integer storeId) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.storeId = storeId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}
