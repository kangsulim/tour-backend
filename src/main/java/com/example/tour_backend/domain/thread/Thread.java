package com.example.tour_backend.domain.thread;

import com.example.tour_backend.domain.user.Users;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "thread")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //JPA에서 기본 키(PK)를 자동으로 생성하는 방법을 지정
    private Long threadid; //Long은 64비트 숫자 자료형(Long 타입)

    @ManyToOne //한 회원(Users)이 여러 게시글(Thread)을 쓸 수 있다는 뜻
    @JoinColumn(name = "userid") //DB에서 연결할 컬럼명 지정
    private Users user;

    @Column(nullable = false)
    private String title; //게시글 제목

    @Lob //길이 제한 없이 큰 텍스트 저장 가능
    private String content;

    @Column(nullable = false)
    private String author;

    private int count = 0; //게시글 조회수 (처음엔 0)

    private int heart = 0; //게시글 조회수 (처음엔 0)

    @Column(nullable = false)
    private String pdfPath; //없으면 게시글에 PDF 첨부 기능 불가

    private int commentCount = 0; //게시글에 달린 댓글 수

    private String area; //여행 지역 정보

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime modifiedDate;


}
