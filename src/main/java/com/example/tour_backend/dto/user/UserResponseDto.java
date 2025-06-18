package com.example.tour_backend.dto.user;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseDto {
    private Long userid;
    private String email;
    private String name;
    private String phone;
    private String nickname;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
}
