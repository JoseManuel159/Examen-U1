package com.example.jmqmatricula.dto;

public class Estudiante {
    private Long id;
    private String dni;
    private String nombre;
    private String carrera;
    private String estado;
    private Integer cicloActual;

    public Estudiante() {
    }

    public Estudiante(Long id, String dni, String nombre, String carrera, String estado, Integer cicloActual) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.carrera = carrera;
        this.estado = estado;
        this.cicloActual = cicloActual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCicloActual() {
        return cicloActual;
    }

    public void setCicloActual(Integer cicloActual) {
        this.cicloActual = cicloActual;
    }
}
