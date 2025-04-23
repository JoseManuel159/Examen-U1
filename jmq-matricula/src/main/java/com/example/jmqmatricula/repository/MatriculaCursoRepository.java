package com.example.jmqmatricula.repository;

import com.example.jmqmatricula.entity.MatriculaCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaCursoRepository extends JpaRepository<MatriculaCurso, Integer> {

    List<MatriculaCurso> findByMatriculaId(Long matriculaId);

    boolean existsByMatriculaIdAndCursoId(Long matriculaId, Long cursoId);
}
