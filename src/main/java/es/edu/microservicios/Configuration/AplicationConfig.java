package es.edu.microservicios.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.ToString;
//comentario
@Configuration
@Data
@ToString
@ConfigurationProperties(prefix = "app")
public class AplicationConfig {

	
	@Value("${app.name}")
	private String name;
	
	@Value("${app.year}")	
	private Integer year;
	
	@Value("${app.edition}")	
	private String edition;
	
	@Value("${app.countries}")	
	private String [] countries;
	
}

