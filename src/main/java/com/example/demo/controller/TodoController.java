package com.example.demo.controller;

import com.example.demo.domain.Todo;
import com.example.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 이 클래스가 REST API를 처리하는 컨트롤러임을 명시
@RequestMapping("/api/todos") // 모든 API 주소 앞에 /api/todos가 붙음
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // 1. 모든 할 일 목록 조회 (GET http://localhost:8080/api/todos)
    @GetMapping
    public List<Todo> getAll() {
        return todoService.findAllTodos();
    }

    // 2. 새로운 할 일 추가 (POST http://localhost:8080/api/todos)
    @PostMapping
    public Todo create(@RequestBody String title) {
        return todoService.createTodo(title);
    }
}