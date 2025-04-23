package com.example.jmqmatricula.service.serviceImpl;

import com.example.jmqmatricula.entity.Matricula;

import com.example.jmqmatricula.repository.MatriculaRepository;
import com.example.jmqmatricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> listar() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        matricula.setFechaMatricula(LocalDate.now());
        return matriculaRepository.save(matricula);
    }

    @Override
    public Optional<Matricula> buscarPorId(Long id) {
        return matriculaRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        matriculaRepository.deleteById(id);
    }
}
