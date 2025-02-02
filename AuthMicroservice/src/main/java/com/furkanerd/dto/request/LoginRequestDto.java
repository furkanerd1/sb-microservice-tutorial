package com.furkanerd.dto.request;

import lombok.Builder;

@Builder
public record LoginRequestDto(
        String userName,
        String password
){}
