package com.github.levry.imq.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class ImqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImqDemoApplication.class, args);
    }

}
