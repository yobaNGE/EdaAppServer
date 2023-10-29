package com.example.edaappserver.repositories;

import com.example.edaappserver.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
     Optional<UserEntity> findByEmail(String email);

     @Override
     void delete(UserEntity entity);

}
