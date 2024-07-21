package com.msebastiao.sap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "repuestos")
public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ficha_mecanica_id", nullable = false)
    private FichaMecanica fichaMecanica;

    public Repuesto(Integer id, String nombre, int cantidad, FichaMecanica fichaMecanica) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fichaMecanica = fichaMecanica;
    }

    public Repuesto(String nombre, int cantidad, FichaMecanica fichaMecanica) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fichaMecanica = fichaMecanica;
    }

    public Repuesto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public FichaMecanica getFichaMecanica() {
        return fichaMecanica;
    }

    public void setFichaMecanica(FichaMecanica fichaMecanica) {
        this.fichaMecanica = fichaMecanica;
    }
}