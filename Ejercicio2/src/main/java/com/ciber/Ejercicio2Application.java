package com.ciber;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Ejercicio2Application {

  public static void main(String[] args) {
    SpringApplication.run(Ejercicio2Application.class, args);
  }

}
