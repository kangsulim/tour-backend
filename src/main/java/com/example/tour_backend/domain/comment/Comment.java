package com.example.tour_backend.domain.comment;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.example.tour_backend.domain.thread.Thread;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "threadid", nullable = false)
    private Thread thread;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime modifiedDate;
}
