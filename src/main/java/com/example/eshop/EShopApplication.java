package com.example.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class EShopApplication {

    public static void main (String[] args) {
        SpringApplication.run(EShopApplication.class, args);
    }

}
