package com.example.jmqmatricula.feign;

import com.example.jmqmatricula.dto.Curso;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "jmq-curso-service", path = "/curso")
public interface CursoFeign {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "clientByIdCB", fallbackMethod = "fallbackClientById")
    public ResponseEntity<Curso> listarcurso(@PathVariable Long id);

    @PutMapping("/{id}/capacidad")
    @CircuitBreaker(name = "clientByIdCB", fallbackMethod = "fallbackClientById")
    ResponseEntity<Curso> actualizarCapacidad(@PathVariable Long id, @RequestBody Integer nuevaCapacidad);

    default ResponseEntity<Curso> fallbackClientById(Long id, Exception e) {
        Curso curso = new Curso();
        curso.setNombre("Servicio no disponible de curso");
        return ResponseEntity.ok(curso);
    }




}
