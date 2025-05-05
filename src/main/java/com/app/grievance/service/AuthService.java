package com.app.grievance.service;
import com.app.grievance.controller.AuthController;
import com.app.grievance.dto.LoginRequest;
import com.app.grievance.dto.LoginResponse;
import com.app.grievance.dto.RegisterRequest;
import com.app.grievance.exception.CustomException;
import com.app.grievance.model.User;
import com.app.grievance.repository.UserRepository;
import com.app.grievance.security.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    public LoginResponse login(LoginRequest loginRequest) {
        String token;
        User user;
        logger.info("Logg Before Authentication: {}", loginRequest);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        logger.info("Logg after Authentication: {}", authentication);
        token = jwtTokenProvider.generateToken(authentication.getName());
        logger.info("Token: {}", token);
        user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new CustomException("User not found"));

        return new LoginResponse(token, user.getUsername(), user.getEmail());
    }

    public String register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new CustomException("Username is already taken.");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new CustomException("Email is already taken.");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));


        userRepository.save(user);

        return jwtTokenProvider.generateToken(user.getUsername());
    }
}
