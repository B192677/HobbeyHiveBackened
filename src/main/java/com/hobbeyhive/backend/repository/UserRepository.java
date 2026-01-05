package com.hobbeyhive.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hobbeyhive.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
