package com.example.edaappserver.repositories;

import com.example.edaappserver.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);

    @Override
    void delete(UserEntity entity);

    @Override
    void deleteById(Integer integer);
}
