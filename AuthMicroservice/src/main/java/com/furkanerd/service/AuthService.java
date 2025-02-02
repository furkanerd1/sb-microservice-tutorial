package com.furkanerd.service;

import com.furkanerd.dto.request.CreateUserRequestDto;
import com.furkanerd.dto.request.LoginRequestDto;
import com.furkanerd.dto.request.RegisterRequestDto;
import com.furkanerd.entity.Auth;
import com.furkanerd.manager.UserProfileManager;
import com.furkanerd.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;

    public AuthService(AuthRepository repository, UserProfileManager userProfileManager) {
        this.repository = repository;
        this.userProfileManager = userProfileManager;
    }

    public Auth register(RegisterRequestDto request) {
        Auth auth=  repository.save(Auth.builder()
                .userName(request.userName())
                .email(request.email())
                .password(request.password())
                .build()
        );
        userProfileManager.createUser(CreateUserRequestDto.builder()
                .authId(auth.getId())
                .email(auth.getEmail())
                .userName(auth.getUserName())
                .build());

        return auth;
    }

    public Boolean login(LoginRequestDto request) {
        return repository.existsByUserNameAndPassword(request.userName(),request.password());
    }
}
