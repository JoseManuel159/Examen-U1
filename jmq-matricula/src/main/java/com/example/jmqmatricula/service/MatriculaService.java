package com.example.jmqmatricula.service;

import com.example.jmqmatricula.entity.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    List<Matricula> listar();
    Matricula guardar(Matricula matricula);
    Optional<Matricula> buscarPorId(Long id);
    void eliminar(Long id);
}
