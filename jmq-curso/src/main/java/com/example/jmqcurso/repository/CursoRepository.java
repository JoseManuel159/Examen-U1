package com.example.jmqcurso.repository;

import com.example.jmqcurso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    // Para validar que el código del curso sea único
    Optional<Curso> findByCodigo(String codigo);

}