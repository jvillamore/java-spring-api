package com.villa.java_market.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
public class ComprasProductoPK implements Serializable {
    @Column(name = "id_compra")
    @Getter @Setter
    private Integer idCompra;

    @Column(name = "id_producto")
    @Getter @Setter
    private Integer idProducto;
}