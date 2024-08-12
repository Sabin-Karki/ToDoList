package com.example.secondStarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
@SpringBootApplication
//@RestController
//@RequestMapping("/dice")
public class SecondStarterApplication {


	public static void main(String[] args) {
		SpringApplication.run(SecondStarterApplication.class, args);
	}
}
