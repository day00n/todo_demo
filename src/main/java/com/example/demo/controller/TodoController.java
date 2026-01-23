package com.example.demo.controller;

import com.example.demo.domain.Todo;
import com.example.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos") // 모든 API 주소 앞에 /api/todos가 붙음
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    
    // 목록 조회 (GET http://localhost:8080/api/todos)
    @GetMapping
    public List<Todo> getAll() {
        return todoService.findAllTodos();
    }
    
    // 추가 (POST http://localhost:8080/api/todos)
    @PostMapping
    public Todo create(@RequestBody String title) {
        return todoService.createTodo(title);
    }
    
    // 토글 
    @PatchMapping("/{id}/toggle")
    public Todo toggle(@PathVariable Long id){
        return todoService.toggleTodo(id);
    }
    
    //삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        todoService.deleteTodo(id);
    }
}