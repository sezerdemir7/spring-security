package com.demir.security.jwttoken.dto;

public record AuthRequest(
        String username,
        String password
) {
}
