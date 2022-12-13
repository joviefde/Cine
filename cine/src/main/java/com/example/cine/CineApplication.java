package com.example.cine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.gui.Ventana.lanzar;

@SpringBootApplication

public class CineApplication {

	public static void main(String[] args) {
		lanzar(args);
	}

}
