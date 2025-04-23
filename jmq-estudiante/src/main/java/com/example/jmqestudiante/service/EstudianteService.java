package com.example.jmqestudiante.service;

import com.example.jmqestudiante.entity.Estudiante;

import java.util.List;

public interface EstudianteService {

    Estudiante crearEstudiante(Estudiante estudiante);

    Estudiante obtenerEstudiantePorId(Long id);

    List<Estudiante> listarEstudiantes();

    Estudiante actualizarEstudiante(Long id, Estudiante estudiante);

    void eliminarEstudiante(Long id);

}
