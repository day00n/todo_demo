package com.example.demo.service;

import com.example.demo.domain.Todo;
import com.example.demo.domain.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // 데이터 변경 작업은 트랜잭션 안에서 이루어져야 함
@RequiredArgsConstructor // Repository를 주입(Injection)받기 위해 사용
public class TodoService {

    private final TodoRepository todoRepository;

    // 할 일 생성
    public Todo createTodo(String title) {
        Todo todo = Todo.builder()
                .title(title)
                .completed(false)
                .build();
        return todoRepository.save(todo);
    }

    // 모든 할 일 조회
    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }
}