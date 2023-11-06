package com.epam.upskil.service;

import com.epam.upskil.model.TodoItem;

import java.util.List;

/**
 * @className: TodoService  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 2:46 PM 13 $
 * @author: Qudratjon Komilov
 */
public interface TodoService {
    TodoItem createTodoItem(TodoItem todoItem);

    List<TodoItem> getAllTodoItems();

    TodoItem getTodoItemById(Long id);

    TodoItem updateTodoItem(Long id, TodoItem todoItemDetails);

    void deleteTodoItem(Long id);
}
