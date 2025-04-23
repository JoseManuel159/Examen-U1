package com.example.jmqmatricula.repository;

import com.example.jmqmatricula.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    // Para evitar que un estudiante se matricule dos veces en el mismo curso
    List<Matricula> findByIdEstudiante(Long idEstudiante);
    boolean existsByIdEstudianteAndCursos_CursoId(Long idEstudiante, Long cursoId);

}