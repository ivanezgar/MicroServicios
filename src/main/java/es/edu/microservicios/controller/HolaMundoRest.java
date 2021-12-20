package es.edu.microservicios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.edu.microservicios.Configuration.AplicationConfig;

@RestController

//commit branch
public class HolaMundoRest {
	
	@Autowired
	private AplicationConfig appConfig;

	@GetMapping("/holaMundo")
	public String saludo(){
		
		
		System.out.println(appConfig.toString());
		return "Hola Mundo Servicio Rest Java";
	}
}
