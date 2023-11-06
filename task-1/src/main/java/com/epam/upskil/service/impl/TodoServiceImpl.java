package com.epam.upskil.service.impl;


import com.epam.upskil.exception.ResourceNotFoundException;
import com.epam.upskil.model.TodoItem;
import com.epam.upskil.repository.TodoItemRepository;
import com.epam.upskil.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: TodoServiceImpl  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 2:46 PM 55 $
 * @author: Qudratjon Komilov
 */
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @Override
    public TodoItem createTodoItem(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    @Override
    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll();
    }

    @Override
    public TodoItem getTodoItemById(Long id) {
        return todoItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TodoItem not found with id " + id));
    }

    @Override
    public TodoItem updateTodoItem(Long id, TodoItem todoItemDetails) {
        TodoItem todoItem = getTodoItemById(id);
        todoItem.setTitle(todoItemDetails.getTitle());
        todoItem.setDescription(todoItemDetails.getDescription());
        return todoItemRepository.save(todoItem);
    }

    @Override
    public void deleteTodoItem(Long id) {
        TodoItem todoItem = getTodoItemById(id);
        todoItemRepository.delete(todoItem);
    }
}