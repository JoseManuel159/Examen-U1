package com.example.jmqmatricula.entity;


import com.example.jmqmatricula.dto.Estudiante;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idEstudiante;

    @Transient
    private Estudiante estudiante;

    private Integer ciclo;

    private LocalDate fechaMatricula;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "matricula_id")
    private List<MatriculaCurso> cursos;

    public Matricula() {
    }

    public Matricula(Long id, Long idEstudiante, Estudiante estudiante, Integer ciclo, LocalDate fechaMatricula, List<MatriculaCurso> cursos) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.estudiante = estudiante;
        this.ciclo = ciclo;
        this.fechaMatricula = fechaMatricula;
        this.cursos = cursos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public List<MatriculaCurso> getCursos() {
        return cursos;
    }

    public void setCursos(List<MatriculaCurso> cursos) {
        this.cursos = cursos;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
