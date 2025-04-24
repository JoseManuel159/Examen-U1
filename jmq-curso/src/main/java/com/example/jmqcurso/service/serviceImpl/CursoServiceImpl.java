package com.example.jmqcurso.service.serviceImpl;

import com.example.jmqcurso.entity.Curso;
import com.example.jmqcurso.repository.CursoRepository;
import com.example.jmqcurso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Curso guardarCurso(Curso curso) {
        // Validar que no exista un curso con el mismo código
        if (cursoRepository.findByCodigo(curso.getCodigo()).isPresent()) {
            throw new RuntimeException("El código del curso ya existe");
        }
        return cursoRepository.save(curso);
    }

    @Override
    public Curso actualizarCurso(Long id, Curso curso) {
        Curso existente = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
        existente.setCodigo(curso.getCodigo());
        existente.setNombre(curso.getNombre());
        existente.setHorario(curso.getHorario());
        existente.setCapacidad(curso.getCapacidad());
        existente.setCiclo(curso.getCiclo());

        return cursoRepository.save(existente);
    }

    @Override
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Optional<Curso> obtenerPorCodigo(String codigo) {
        return cursoRepository.findByCodigo(codigo);
    }

    @Override
    public Curso actualizarCapacidad(Long id, Integer nuevaCapacidad) {
        Curso existente = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
        existente.setCapacidad(nuevaCapacidad);
        return cursoRepository.save(existente);
    }


}
