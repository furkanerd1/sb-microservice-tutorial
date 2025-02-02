package com.furkanerd.service;

import com.furkanerd.dto.request.LoginRequestDto;
import com.furkanerd.dto.request.RegisterRequestDto;
import com.furkanerd.entity.Auth;
import com.furkanerd.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository repository;

    public AuthService(AuthRepository repository) {
        this.repository = repository;
    }

    public Auth register(RegisterRequestDto request) {
        return repository.save(Auth.builder()
                .userName(request.userName())
                .email(request.email())
                .password(request.password())
                .build()
        );
    }

    public Boolean login(LoginRequestDto request) {
        return repository.existsByUserNameAndPassword(request.userName(),request.password());
    }
}
