package com.msebastiao.sap.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titular_vehiculo_id") // Nombre de la columna en la tabla turnos que referencia al titular
    private TitularVehiculo titularVehiculo; // Relación con TitularVehiculo


    public Turno(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, String estado, TitularVehiculo titularVehiculo) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
        this.titularVehiculo = titularVehiculo;
    }

    public Turno(int id, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, String estado, TitularVehiculo titularVehiculo) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
        this.titularVehiculo = titularVehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TitularVehiculo getTitularVehiculo() {
        return titularVehiculo;
    }

    public void setTitularVehiculo(TitularVehiculo titularVehiculo) {
        this.titularVehiculo = titularVehiculo;
    }

}
