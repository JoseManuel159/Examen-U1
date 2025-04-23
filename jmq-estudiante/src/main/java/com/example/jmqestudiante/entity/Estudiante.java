package com.example.jmqestudiante.entity;

import jakarta.persistence.*;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    private String carrera;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEstudiante estado;

    private Integer cicloActual;

    public enum EstadoEstudiante {
        ACTIVO,
        INACTIVO
    }

    public Estudiante() {
    }

    public Estudiante(Long id, String dni, String nombre, String carrera, EstadoEstudiante estado, Integer cicloActual) {
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

    public EstadoEstudiante getEstado() {
        return estado;
    }

    public void setEstado(EstadoEstudiante estado) {
        this.estado = estado;
    }

    public Integer getCicloActual() {
        return cicloActual;
    }

    public void setCicloActual(Integer cicloActual) {
        this.cicloActual = cicloActual;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}