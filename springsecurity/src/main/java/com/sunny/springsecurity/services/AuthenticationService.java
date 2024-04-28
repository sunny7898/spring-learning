package com.sunny.springsecurity.services;


import com.sunny.springsecurity.dto.JwtAuthenticationResponse;
import com.sunny.springsecurity.dto.RefreshTokenRequest;
import com.sunny.springsecurity.dto.SignInRequest;
import com.sunny.springsecurity.dto.SignUpRequest;
import com.sunny.springsecurity.entities.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
