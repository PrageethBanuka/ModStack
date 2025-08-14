package com.modstack.backend.dto;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {

}
