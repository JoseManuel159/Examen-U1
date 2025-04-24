package com.example.jmqmatricula.service.serviceImpl;

import com.example.jmqmatricula.dto.Curso;
import com.example.jmqmatricula.dto.Estudiante;
import com.example.jmqmatricula.entity.Matricula;

import com.example.jmqmatricula.entity.MatriculaCurso;
import com.example.jmqmatricula.feign.CursoFeign;
import com.example.jmqmatricula.feign.EstudianteFeign;
import com.example.jmqmatricula.repository.MatriculaCursoRepository;
import com.example.jmqmatricula.repository.MatriculaRepository;
import com.example.jmqmatricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private MatriculaCursoRepository matriculaCursoRepository;

    @Autowired
    private CursoFeign cursoFeign;

    @Autowired
    private EstudianteFeign estudianteFeign;

    @Override
    public List<Matricula> listar() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        matricula.setFechaMatricula(LocalDate.now());

        // Verificar si el estudiante está activo
        Estudiante estudiante = estudianteFeign.Listarestudiante(matricula.getIdEstudiante()).getBody();

        if (estudiante == null) {
            throw new RuntimeException("Estudiante con ID " + matricula.getIdEstudiante() + " no encontrado");
        }

        if (!"ACTIVO".equalsIgnoreCase(estudiante.getEstado())) {
            throw new RuntimeException("El estudiante con ID " + estudiante.getId() + " no está activo y no puede ser matriculado.");
        }

        // Verificación y actualización de capacidad por cada curso
        for (MatriculaCurso mc : matricula.getCursos()) {
            Curso curso = cursoFeign.listarcurso(mc.getCursoId()).getBody();

            if (curso == null) {
                throw new RuntimeException("Curso con ID " + mc.getCursoId() + " no encontrado");
            }

            // Verificar si el estudiante ya está matriculado en este curso
            if (matriculaCursoRepository.existsByCursoIdAndMatricula_IdEstudiante(mc.getCursoId(), matricula.getIdEstudiante())) {
                throw new RuntimeException("El estudiante ya está matriculado en el curso: " + curso.getNombre());
            }

            // Verificación de capacidad
            if (curso.getCapacidad() <= 0) {
                throw new RuntimeException("No hay capacidad disponible para el curso: " + curso.getNombre());
            }

            // Actualizar la capacidad
            int nuevaCapacidad = curso.getCapacidad() - 1;
            cursoFeign.actualizarCapacidad(curso.getId(), nuevaCapacidad);

            // (Opcional) para que se devuelva en el response completo
            mc.setCurso(curso);
        }

        return matriculaRepository.save(matricula);
    }


    @Override
    public Optional<Matricula> buscarPorId(Long id) {
        Matricula matricula = matriculaRepository.findById(id).orElse(null);

        if (matricula == null) {
            return Optional.empty();
        }

        // Obtener los datos del estudiante desde el microservicio
        Estudiante estudiante = estudianteFeign.Listarestudiante(matricula.getIdEstudiante()).getBody();
        matricula.setEstudiante(estudiante); // asumiendo que tienes un campo @Transient Estudiante en la entidad

        // Para cada MatriculaCurso, obtener el Curso correspondiente
        List<MatriculaCurso> cursosConDatos = matricula.getCursos().stream().map(matriculaCurso -> {
            Curso curso = cursoFeign.listarcurso(matriculaCurso.getCursoId()).getBody();
            matriculaCurso.setCurso(curso); // asumiendo que tienes un campo @Transient Curso en la entidad
            return matriculaCurso;
        }).collect(Collectors.toList());

        matricula.setCursos(cursosConDatos);

        return Optional.of(matricula);    }

    @Override
    public void eliminar(Long id) {
        matriculaRepository.deleteById(id);
    }
}
