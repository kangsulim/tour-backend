package com.example.tour_backend.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <Users, Long> {
    Optional<Users> findByEmail(String email);
    Optional<Users> findByNickname(String nickname);

    Optional<Object> findByUsername(String username);
}
