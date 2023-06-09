package ru.fifthelementserver.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthController {
    @GetMapping("/ping")
    public ResponseEntity<?> ping() {
        return ResponseEntity.ok("1;OK");
    }
}
