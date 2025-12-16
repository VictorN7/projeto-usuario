package br.com.victornogueira.projeto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victornogueira.projeto.dto.UserDTO;
import br.com.victornogueira.projeto.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private UserService userService; 
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<UserDTO> list(){
		return userService.listUsers(); 
	}
	
	@PostMapping
	public void create(@RequestBody UserDTO userDto) {
		userService.createUser(userDto);
	}
	
	@PutMapping
	public UserDTO update(@RequestBody UserDTO userDto) {
		return userService.updateUser(userDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}
}