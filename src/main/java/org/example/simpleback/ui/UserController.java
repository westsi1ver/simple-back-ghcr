package org.example.simpleback.ui;

import lombok.RequiredArgsConstructor;
import org.example.simpleback.app.UserQueryUseCase;
import org.example.simpleback.domain.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserQueryUseCase userQueryUseCase;

    @Value("${app.message}")
    private String appMessage;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> root() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "UP");
        response.put("message", appMessage);
        response.put("timestamp", Instant.now().toString());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userQueryUseCase.getUsers());
    }
}
