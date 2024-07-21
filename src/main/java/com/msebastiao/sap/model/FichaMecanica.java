package com.msebastiao.sap.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fichas_mecanicas")
public class FichaMecanica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mecanico_id")
    private Mecanico mecanico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titular_vehiculo_id")
    private TitularVehiculo titularVehiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "estado", length = 50)
    private String estado;

    @OneToMany(mappedBy = "fichaMecanica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Actividad> actividadesRealizadas;

    @OneToMany(mappedBy = "fichaMecanica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Repuesto> repuestosEmpleados;


    public FichaMecanica(TitularVehiculo titularVehiculo, Vehiculo vehiculo,
                         LocalDate fechaInicio) {
        this.titularVehiculo = titularVehiculo;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.estado = "Pendiente";
        this.actividadesRealizadas = new ArrayList<>();
        this.repuestosEmpleados = new ArrayList<>();
    }

    public FichaMecanica(int id, Mecanico mecanico, TitularVehiculo titularVehiculo, Vehiculo vehiculo,
                         LocalDate fechaInicio, LocalDate fechaFin, String estado,
                         List<Actividad> actividadesRealizadas, List<Repuesto> repuestosEmpleados) {
        this.id = id;
        this.mecanico = mecanico;
        this.titularVehiculo = titularVehiculo;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.actividadesRealizadas = actividadesRealizadas;
        this.repuestosEmpleados = repuestosEmpleados;
    }

    public FichaMecanica() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public TitularVehiculo getTitularVehiculo() {
        return titularVehiculo;
    }

    public void setTitularVehiculo(TitularVehiculo titularVehiculo) {
        this.titularVehiculo = titularVehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Actividad> getActividadesRealizadas() {
        return actividadesRealizadas;
    }

    public void setActividadesRealizadas(List<Actividad> actividadesRealizadas) {
        this.actividadesRealizadas = actividadesRealizadas;
    }

    public List<Repuesto> getRepuestosEmpleados() {
        return repuestosEmpleados;
    }

    public void setRepuestosEmpleados(List<Repuesto> repuestosEmpleados) {
        this.repuestosEmpleados = repuestosEmpleados;
    }

    @Override
    public String toString() {
        return "Ficha #" + id +
                " / " + titularVehiculo +
                " / " + vehiculo +
                " (" + fechaInicio.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ")";
    }
}