package com.springboot.osgi.springbootosgi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.springboot.osgi" })
public class SpringbootOsgiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootOsgiApplication.class, args);
    }

}
