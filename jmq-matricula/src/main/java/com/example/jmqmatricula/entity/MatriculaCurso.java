package com.example.jmqmatricula.entity;

import com.example.jmqmatricula.dto.Curso;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class MatriculaCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "curso_id")
    private Long cursoId;

    @Transient
    private Curso curso;

    @ManyToOne
    @JsonIgnore  // <- Esto evita que se serialice de vuelta a Matricula
    private Matricula matricula;

    public MatriculaCurso() {
    }

    public MatriculaCurso(Integer id, Long cursoId, Curso curso, Matricula matricula) {
        this.id = id;
        this.cursoId = cursoId;
        this.curso = curso;
        this.matricula = matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
}
