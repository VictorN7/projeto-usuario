package br.com.victornogueira.projeto.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.victornogueira.projeto.dto.UserDTO;
import br.com.victornogueira.projeto.entity.UserEntity;
import br.com.victornogueira.projeto.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void createUser(UserDTO userDto) {
		userRepository.save(new UserEntity(userDto));
	}
	
	public List<UserDTO> listUser(){
		List<UserEntity> userEntity = userRepository.findAll();
		return userEntity.stream().map(UserDTO::new).toList();
	}
	
	public UserDTO updateUser(UserDTO userDTO) {
		return new UserDTO(userRepository.save(new UserEntity(userDTO)));
	}

	public void deleteUser(Long id) {
		UserEntity userEntity = userRepository.findById(id).get();
		userRepository.delete(userEntity);
	}
}