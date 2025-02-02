package com.furkanerd.repository;

import com.furkanerd.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Boolean existsByUserNameAndPassword(String s, String password);
}
