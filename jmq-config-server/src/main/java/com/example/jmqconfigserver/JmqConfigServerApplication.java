package com.example.jmqconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class JmqConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmqConfigServerApplication.class, args);
    }

}
