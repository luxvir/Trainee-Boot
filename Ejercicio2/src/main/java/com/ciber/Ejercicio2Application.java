package com.ciber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Ejercicio2Application {

  public static void main(String[] args) {
    SpringApplication.run(Ejercicio2Application.class, args);
  }

}
