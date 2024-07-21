package com.msebastiao.sap.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "informes")
public class Informe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "contenido", length = 1000)
    private String contenido;

    public Informe(Integer id, LocalDate fecha, String contenido) {
        this.id = id;
        this.fecha = fecha;
        this.contenido = contenido;
    }

    public Informe(LocalDate fecha, String contenido) {
        this.fecha = fecha;
        this.contenido = contenido;
    }

    public Informe() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
