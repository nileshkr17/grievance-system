package com.app.grievance.controller;
import com.app.grievance.dto.LoginRequest;
import com.app.grievance.dto.LoginResponse;
import com.app.grievance.dto.RegisterRequest;
import com.app.grievance.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        logger.info("Login request received for username: {}", request.getUsername());
        try {
            // Perform login logic
            LoginResponse response = authService.login(request);

            // Log the successful login response
            logger.info("Login successful for username: {}, returning response: {}", request.getUsername(), response);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the exception if something goes wrong
            logger.error("Error occurred during login attempt for username: {}", request.getUsername(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred during login");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        String token = authService.register(request);
        // System.out.println("Register request: " + request);
        return ResponseEntity.ok().body("Bearer " + token);
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test endpoint");
    }
}
