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
@Table(name = "store")
public class Store implements Serializable {

    @Id
    @Column(name = "store_id")
    private Integer storeId;

    @NotBlank(message = "El nombre de la tienda es obligatorio")
    @NotEmpty(message = "El nombre de la tienda es obligatorio")
    @NotNull(message = "El nombre de la tienda es obligatorio")
    @Column(name = "store_name")
    private String storeName;

    public Store(Integer storeId, @NotBlank @NotEmpty @NotNull String storeName) {
        this.storeId = storeId;
        this.storeName = storeName;
    }

    public Store() {
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
