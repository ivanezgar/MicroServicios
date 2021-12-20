package es.edu.microservicios.controller;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.edu.microservicios.model.AccountDTO;
import es.edu.microservicios.model.UserDTO;
import lombok.Delegate;

@RestController
@RequestMapping("/users")
public class UserControllerRest {

	
	//alta
	//baja
	//modificacion
	//get de usuarios
	
	@GetMapping("/{id}")
	public ResponseEntity <UserDTO> getUserById(@PathVariable Integer id) {
		
		System.out.println("Recovery user by id");
		
		//UserDTO user = service.getUserById(id);
		
//		if(user == null) {
//			
//			
//		}
		
		UserDTO userDTO = new UserDTO(1, "Iván");
		userDTO.setEdad(38);
		userDTO.setLastname("Pérez"); 
		
		return ResponseEntity.ok(userDTO);
		
	}
	
	@GetMapping()
	public ResponseEntity<List<UserDTO>> listAllUsers(@RequestParam(required = false) String name,
									  @RequestParam(required = false) String lastname,
									  @RequestParam(required = false) Integer age){
		List<UserDTO> list = List.of(new UserDTO(1, "Iván"),new UserDTO(2, "Paco"),new UserDTO(3, "Eusebio"));
		
		list = list.stream().filter(u -> u.getName().contains(name)).collect(Collectors.toList());
		
		return ResponseEntity.ok(list);
	}
	
	@PostMapping()
	public ResponseEntity<String> createrUser(@RequestBody UserDTO userDTO){
		
		System.out.println("Creating user"+userDTO.getName());
		
		URI location = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(userDTO.getId()).
				toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping()
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
		
		System.out.println("updating data");
		
		return ResponseEntity.ok(userDTO);
		
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
		
		System.out.println("delete user by id");
		return ResponseEntity.ok(null);
		
	}
	@GetMapping("/{id}/accounts")
	public ResponseEntity<List<AccountDTO>> getUserAccounts(@PathVariable Integer id){
		
		List<AccountDTO> list = List.of(new AccountDTO("google"),new AccountDTO("twitter"),new AccountDTO("facebook"));
		
		return ResponseEntity.ok(list);
	}
	@GetMapping("/{id}/accounts/{idAcoount}")
	public ResponseEntity<AccountDTO> getUserAccountById(@PathVariable Integer id,@PathVariable Integer idAccount){
			
		return ResponseEntity.ok(new AccountDTO("google"));
	}
 	
	
}
