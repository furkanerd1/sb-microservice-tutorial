package com.furkanerd.dto.request;

import lombok.Builder;

@Builder
public record RegisterRequestDto(
        String userName,
        String password,
        String repassword,
        String email
){}
