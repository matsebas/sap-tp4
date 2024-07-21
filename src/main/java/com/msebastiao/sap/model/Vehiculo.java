package com.msebastiao.sap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "marca", nullable = false, length = 100)
    private String marca;

    @Column(name = "modelo", nullable = false, length = 100)
    private String modelo;

    @Column(name = "anio", nullable = false)
    private int anio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "titular_vehiculo_id")
    private TitularVehiculo titularVehiculo; // Relación con TitularVehiculo

    public Vehiculo(int id, String marca, String modelo, int anio, TitularVehiculo titularVehiculo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.titularVehiculo = titularVehiculo;
    }

    public Vehiculo(String marca, String modelo, int anio, TitularVehiculo titularVehiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.titularVehiculo = titularVehiculo;
    }

    public Vehiculo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public TitularVehiculo getTitularVehiculo() {
        return titularVehiculo;
    }

    public void setTitularVehiculo(TitularVehiculo titularVehiculo) {
        this.titularVehiculo = titularVehiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;
        return id == vehiculo.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return marca + ' ' + modelo;
    }
}
