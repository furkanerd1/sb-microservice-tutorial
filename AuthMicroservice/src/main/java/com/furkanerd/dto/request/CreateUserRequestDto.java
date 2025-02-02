package com.furkanerd.dto.request;

import lombok.Builder;

@Builder
public record CreateUserRequestDto(
        Long authId,
        String userName,
        String email
){}
