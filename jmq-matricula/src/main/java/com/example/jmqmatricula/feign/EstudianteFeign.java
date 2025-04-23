package com.example.jmqmatricula.feign;

import com.example.jmqmatricula.dto.Estudiante;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "jmq-estudiante-service", path = "/estudiante")
public class EstudianteFeign {
}
