package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity // 이 클래스가 DB 테이블과 매핑됨을 의미
@Getter // Getter 메서드 자동 생성
@NoArgsConstructor // 파라미터 없는 기본 생성자 자동 생성
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 자동 증가 (MySQL의 Auto Increment와 같음)
    private Long id;

    @Column(nullable = false) // null일 수 없음
    private String title;

    private boolean completed; // 완료 여부

    @Builder // 빌더 패턴으로 객체 생성을 도와줌
    public Todo(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }
}
