package com.example.jmqmatricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JmqMatriculaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmqMatriculaApplication.class, args);
    }

}
