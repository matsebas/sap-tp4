package com.msebastiao.sap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "actividades")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "tiempo_empleado")
    private Integer tiempoEmpleado;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "ficha_mecanica_id", nullable = false)
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
