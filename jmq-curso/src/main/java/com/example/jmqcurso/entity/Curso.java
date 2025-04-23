package com.example.jmqcurso.entity;

import jakarta.persistence.*;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codigo; // Código único del curso, como "INF101"

    @Column(nullable = false)
    private String nombre;

    private String horario;

    @Column(nullable = false)
    private Integer capacidad;

    @Column(nullable = false)
    private Integer ciclo;

    public Curso() {
    }

    public Curso(Long id, String codigo, String nombre, String horario, Integer capacidad, Integer ciclo) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
        this.ciclo = ciclo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }


}
