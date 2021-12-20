package es.edu.microservicios.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
public class UserDTO {
	
	@NonNull
	private Integer id;
	@NonNull
	private String name;
	
	private String lastname;
	@ToString.Exclude
	private int edad;

	
}
