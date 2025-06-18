package com.example.tour_backend.web;

import com.example.tour_backend.dto.user.JwtResponse;
import com.example.tour_backend.dto.user.LoginRequestDto;
import com.example.tour_backend.dto.user.UserRequestDto;
import com.example.tour_backend.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tour_backend.service.UserService;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserRequestDto requestDto) {
        UserResponseDto responseDto = userService.registerUser(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 회원 조회 (마이페이지 등)
    @GetMapping("/{userid}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long userid) {
        return userService.getUser(userid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
        try {
            String token = String.valueOf(userService.login(loginRequest)); // 로그인 처리, 토큰 발급
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("로그인 실패: " + e.getMessage());
        }

    }
}