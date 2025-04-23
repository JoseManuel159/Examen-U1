package com.example.jmqmatricula.feign;

import com.example.jmqmatricula.dto.Curso;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "jmq-curso-service", path = "/curso")
public class CursoFeign {


}
