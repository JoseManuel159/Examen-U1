package com.example.jmqmatricula.repository;

import com.example.jmqmatricula.entity.MatriculaCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaCursoRepository extends JpaRepository<MatriculaCurso, Integer> {

    boolean existsByCursoIdAndMatricula_IdEstudiante(Long cursoId, Long idEstudiante);

}
