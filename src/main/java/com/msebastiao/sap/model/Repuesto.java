package com.msebastiao.sap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "repuestos")
public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int cantidad;

    private int fichaMecanicaId;

    public Repuesto(int id, String nombre, int cantidad, int fichaMecanicaId) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fichaMecanicaId = fichaMecanicaId;
    }

    public Repuesto(String nombre, int cantidad, int fichaMecanicaId) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fichaMecanicaId = fichaMecanicaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getFichaMecanicaId() {
        return fichaMecanicaId;
    }

    public void setFichaMecanicaId(int fichaMecanicaId) {
        this.fichaMecanicaId = fichaMecanicaId;
    }
}