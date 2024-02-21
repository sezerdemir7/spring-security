package com.demir.security.basicauth.dto;

import com.demir.security.basicauth.model.Role;
import lombok.Builder;

import java.util.Set;
@Builder
public record CreateUserRequest (
        String name,
        String username,
        String password,
        Set<Role> authorities
){
}
