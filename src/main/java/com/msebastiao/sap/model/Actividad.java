package com.msebastiao.sap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "actividades")
@Entity
public class Actividad {
    
    @Id
    private Integer id;
    private String descripcion;
    private Integer tiempoEmpleado;
    private String estado;
    private Integer fichaMecanicaId;

    public Actividad(int id, String descripcion, int tiempoEmpleado, String estado, int fichaMecanicaId) {
        this.id = id;
        this.descripcion = descripcion;
        this.tiempoEmpleado = tiempoEmpleado;
        this.estado = estado;
        this.fichaMecanicaId = fichaMecanicaId;
    }

    public Actividad(String descripcion, int tiempoEmpleado, String estado, int fichaMecanicaId) {
        this.descripcion = descripcion;
        this.tiempoEmpleado = tiempoEmpleado;
        this.estado = estado;
        this.fichaMecanicaId = fichaMecanicaId;
    }

    public Actividad() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempoEmpleado() {
        return tiempoEmpleado;
    }

    public void setTiempoEmpleado(int tiempoEmpleado) {
        this.tiempoEmpleado = tiempoEmpleado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getFichaMecanicaId() {
        return fichaMecanicaId;
    }

    public void setFichaMecanicaId(int fichaMecanicaId) {
        this.fichaMecanicaId = fichaMecanicaId;
    }

    @Override
    public String toString() {
        return "Actividad #" + id +
                " / " + descripcion +
                " (" + estado + ')';
    }
}
