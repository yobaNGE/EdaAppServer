package com.example.edaappserver.repositories;

import com.example.edaappserver.user.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
     Optional<User> findByEmail(String email);

     @Override
     void delete(User entity);


}
