package com.example.jmqmatricula.feign;

import com.example.jmqmatricula.dto.Estudiante;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "jmq-estudiante-service", path = "/estudiante")
public interface EstudianteFeign {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "orderByIdCB", fallbackMethod = "fallbackProductById")
    public ResponseEntity<Estudiante> Listarestudiante(@PathVariable Long id);

    default ResponseEntity<Estudiante> fallbackProductById(Long id, Exception e) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Servicio no disponible de producto");
        return ResponseEntity.ok(estudiante);
    }

}
