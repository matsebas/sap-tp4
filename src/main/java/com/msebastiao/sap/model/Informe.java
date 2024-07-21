package com.msebastiao.sap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Table(name = "informes")
@Entity
public class Informe {
    @Id
    private Integer id;
    private LocalDate fecha;
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
