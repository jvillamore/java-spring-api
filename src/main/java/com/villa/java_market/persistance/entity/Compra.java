package com.villa.java_market.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    @Setter @Getter
    private Integer idCompra;

    @Column(name = "id_cliente")
    @Setter @Getter
    private String idCliente;

    @Setter @Getter
    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    @Setter @Getter
    private String medioPago;

    @Setter @Getter
    private String comentario;

    @Setter @Getter
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    @Getter @Setter
    private Cliente cliente;

    @OneToMany(mappedBy = "producto")
    @Getter @Setter
    private List<ComprasProducto> productos;
}
