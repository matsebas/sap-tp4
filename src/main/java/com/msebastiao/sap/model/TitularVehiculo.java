package com.msebastiao.sap.model;

import java.util.ArrayList;
import java.util.List;

public class TitularVehiculo {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private List<Vehiculo> vehiculos;


    public TitularVehiculo(int id, String nombre, String apellido, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.vehiculos = new ArrayList<>();
    }

    public TitularVehiculo(int id, String nombre, String apellido, String dni, List<Vehiculo> vehiculos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TitularVehiculo that = (TitularVehiculo) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return nombre + ' ' + apellido;
    }
}
