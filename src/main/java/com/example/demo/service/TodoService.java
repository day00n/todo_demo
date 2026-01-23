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
    
    @Transactional
    public Todo toggleTodo(Long id){
        //1. ID 데이터를 찾고 없으면 에러
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 항목이 없습니다. id=" + id));
        
        //2. 상태 변화
        if(todo.getCompleted()){
            todo.setCompleted(false);
        }else{
            todo.setCompleted(true);
        }
        return todo;
    }
    
    // 모든 할 일 조회
    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }
    
    @Transactional
    public void deleteTodo(Long id){
        // 1. 삭제 id 조회
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("삭제하려는 항목이 없습니다. id=" + id));
        // 2. 삭제 
        todoRepository.delete(todo);
    }
}