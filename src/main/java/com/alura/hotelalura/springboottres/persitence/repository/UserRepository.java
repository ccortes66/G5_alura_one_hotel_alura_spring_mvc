package com.alura.hotelalura.springboottres.persitence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.alura.hotelalura.springboottres.persitence.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity,String>
{
     Optional<UserEntity> findByUsername(String username);
}
