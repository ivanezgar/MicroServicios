package es.edu.microservicios.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountyDTO {
	
	private String isoCode;
	
	private String name;
	
	private String flag;
	

}
