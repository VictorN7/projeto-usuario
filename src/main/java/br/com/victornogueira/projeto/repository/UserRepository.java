package br.com.victornogueira.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victornogueira.projeto.entity.UserEntity;

public interface UserRepository extends  JpaRepository<UserEntity, Long> {

}
