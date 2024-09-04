package com.villa.java_market.persistance.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    @Setter @Getter
    private Integer idProducto;

    @Setter @Getter
    private String nombre;

    @Column(name = "id_categoria")
    @Setter @Getter
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    @Setter @Getter
    private String codigoBarras;

    @Column(name = "precio_venta")
    @Setter @Getter
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    @Setter @Getter
    private Integer cantidadStock;

    @Setter @Getter
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    @Setter @Getter
    private Categoria categoria;
}
