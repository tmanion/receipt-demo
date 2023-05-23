package com.example.demo.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan({"com.example.demo.model.rule", "com.example.demo.service"})
public class DemoSpringTestConfiguration {
    
}
