package com.villa.java_market.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @Setter @Getter
    private String id;

    @Setter @Getter
    private String nombre;

    @Setter @Getter
    private String apellidos;

    @Setter @Getter
    private Long celular;

    @Setter @Getter
    private String direccion;

    @Column(name="correo_electronico")
    @Setter @Getter
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    @Getter @Setter
    private List<Compra> compras;
}
