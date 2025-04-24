package com.example.jmqmatricula.feign;

import com.example.jmqmatricula.dto.Estudiante;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "jmq-estudiante-service", path = "/estudiante")
public interface EstudianteFeign {

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> Listarestudiante(@PathVariable Long id);

}
