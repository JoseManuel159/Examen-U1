package com.example.jmqestudiante.service.serviceimpl;

import com.example.jmqestudiante.entity.Estudiante;
import com.example.jmqestudiante.repository.EstudianteRepository;
import com.example.jmqestudiante.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        // Validar que no exista un estudiante con el mismo DNI
        Optional<Estudiante> estudianteExistente = estudianteRepository.findByDni(estudiante.getDni());
        if (estudianteExistente.isPresent()) {
            throw new RuntimeException("El DNI ya está registrado.");
        }

        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) {
        Estudiante estudianteExistente = obtenerEstudiantePorId(id);

        // Actualizar datos
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setCarrera(estudiante.getCarrera());
        estudianteExistente.setEstado(estudiante.getEstado());
        estudianteExistente.setCicloActual(estudiante.getCicloActual());

        return estudianteRepository.save(estudianteExistente);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        Estudiante estudiante = obtenerEstudiantePorId(id);
        estudianteRepository.delete(estudiante);
    }
}