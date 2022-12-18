package com.nueral.calculator.repository;

import com.nueral.calculator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
    User findByUsername(String username);
}
