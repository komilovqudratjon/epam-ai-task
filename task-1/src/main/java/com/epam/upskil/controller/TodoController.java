package com.epam.upskil.controller;

import com.epam.upskil.model.TodoItem;
import com.epam.upskil.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className: TodoController  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 2:48 PM 21 $
 * @author: Qudratjon Komilov
 */
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
        return todoService.createTodoItem(todoItem);
    }

    @GetMapping
    public List<TodoItem> getAllTodoItems() {
        return todoService.getAllTodoItems();
    }

    @GetMapping("/{id}")
    public TodoItem getTodoItemById(@PathVariable Long id) {
        return todoService.getTodoItemById(id);
    }

    @PutMapping("/{id}")
    public TodoItem updateTodoItem(@PathVariable Long id, @RequestBody TodoItem todoItemDetails) {
        return todoService.updateTodoItem(id, todoItemDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodoItem(@PathVariable Long id) {
        todoService.deleteTodoItem(id);
        return ResponseEntity.ok().build();
    }
}
