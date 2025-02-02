package com.furkanerd.controller;

import com.furkanerd.dto.request.LoginRequestDto;
import com.furkanerd.dto.request.RegisterRequestDto;
import com.furkanerd.entity.Auth;
import com.furkanerd.manager.UserProfileManager;
import com.furkanerd.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.furkanerd.config.RestApis.*;

@RestController
@RequestMapping(AUTHSERVICE)
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto request){
        if(!request.password().equals(request.repassword())){
            throw new RuntimeException("Passwords do not match");
        }
        return ResponseEntity.ok( authService.register(request));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto request){
        return ResponseEntity.ok(authService.login(request));
    }
}
