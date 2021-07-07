package com.example.braintest.model.reqres;

import java.util.List;

public class JwtResponse {

    private Long userId;

    private String token;

    private String username;

    private String email;

    private List<String> roles;

    public JwtResponse(String token, Long userId, String username, String email, List<String> roles) {
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
