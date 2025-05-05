package com.example.jmqmatricula.controller;

import com.example.jmqmatricula.entity.Matricula;
import com.example.jmqmatricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public List<Matricula> listarMatriculas() {
        return matriculaService.listar();
    }

    @PostMapping
    public ResponseEntity<Matricula> registrarMatricula(@RequestBody Matricula matricula) {
        Matricula nueva = matriculaService.guardar(matricula);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> obtenerPorId(@PathVariable Long id) {
        return matriculaService.buscarPorId(id)
                .map(matricula -> new ResponseEntity<>(matricula, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (matriculaService.buscarPorId(id).isPresent()) {
            matriculaService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}