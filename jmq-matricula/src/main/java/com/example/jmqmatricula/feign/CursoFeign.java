package com.example.jmqmatricula.feign;

import com.example.jmqmatricula.dto.Curso;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "jmq-curso-service", path = "/curso")
public interface CursoFeign {

    @GetMapping("/{id}")
    public ResponseEntity<Curso> listarcurso(@PathVariable Long id);

    @PutMapping("/{id}/capacidad")
    ResponseEntity<Curso> actualizarCapacidad(@PathVariable Long id, @RequestBody Integer nuevaCapacidad);


}
