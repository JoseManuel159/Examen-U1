package com.example.jmqcurso.service;


import com.example.jmqcurso.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    Curso guardarCurso(Curso curso);

    Curso actualizarCurso(Long id, Curso curso);

    void eliminarCurso(Long id);

    List<Curso> listarCursos();

    Optional<Curso> obtenerCursoPorId(Long id);

    Optional<Curso> obtenerPorCodigo(String codigo);

    Curso actualizarCapacidad(Long id, Integer nuevaCapacidad);

}