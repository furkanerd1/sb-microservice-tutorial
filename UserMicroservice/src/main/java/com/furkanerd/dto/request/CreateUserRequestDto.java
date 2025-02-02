package com.furkanerd.dto.request;

public record CreateUserRequestDto(
        Long authId,
        String userName,
        String email
){}
