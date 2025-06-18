package com.example.tour_backend.domain.notification;

import com.example.tour_backend.domain.comment.Comment;
import com.example.tour_backend.domain.user.Users;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import com.example.tour_backend.domain.thread.Thread;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    // 수신 회원
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    private Users user;

    // 관련 게시물
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "threadid")
    private Thread thread;

    // 관련 댓글
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentid")
    private Comment comment;

    @Column(nullable = false, length = 225)
    private String message;

    @Column(nullable = false)
    private boolean isRead = false;

    @CreationTimestamp
    private LocalDateTime createDate;
}
