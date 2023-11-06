package com.epam.upskil.service.impl;

import com.epam.upskil.exception.ResourceNotFoundException;
import com.epam.upskil.model.TodoItem;
import com.epam.upskil.repository.TodoItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @className: TodoServiceImplTest  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 3:18 PM 28 $
 * @author: Qudratjon Komilov
 */
@ExtendWith(MockitoExtension.class)
class TodoServiceImplTest {

    @Mock
    private TodoItemRepository todoItemRepository;

    @InjectMocks
    private TodoServiceImpl todoService;

    private TodoItem todoItem;
    private List<TodoItem> todoItemList;

    @BeforeEach
    void setUp() {
        // Initialize your test TodoItem
        todoItem = new TodoItem();
        todoItem.setId(1L);
        todoItem.setTitle("Test Todo");
        todoItem.setDescription("Test Description");

        // Initialize your test list
        todoItemList = new ArrayList<>();
        todoItemList.add(todoItem);
    }

    @Test
    void createTodoItem() {
        when(todoItemRepository.save(any(TodoItem.class))).thenReturn(todoItem);

        TodoItem created = todoService.createTodoItem(todoItem);

        assertNotNull(created);
        assertEquals(todoItem.getTitle(), created.getTitle());
        assertEquals(todoItem.getDescription(), created.getDescription());
    }

    @Test
    void getAllTodoItems() {
        when(todoItemRepository.findAll()).thenReturn(todoItemList);

        List<TodoItem> result = todoService.getAllTodoItems();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(todoItem, result.get(0));
    }

    @Test
    void getTodoItemById() {
        when(todoItemRepository.findById(anyLong())).thenReturn(Optional.of(todoItem));

        TodoItem found = todoService.getTodoItemById(1L);

        assertNotNull(found);
        assertEquals(todoItem.getId(), found.getId());
    }

    @Test
    void updateTodoItem() {
        when(todoItemRepository.findById(anyLong())).thenReturn(Optional.of(todoItem));
        when(todoItemRepository.save(any(TodoItem.class))).thenReturn(todoItem);

        todoItem.setTitle("Updated Title");
        todoItem.setDescription("Updated Description");

        TodoItem updated = todoService.updateTodoItem(1L, todoItem);

        assertNotNull(updated);
        assertEquals("Updated Title", updated.getTitle());
        assertEquals("Updated Description", updated.getDescription());
    }

    @Test
    void deleteTodoItem() {
        when(todoItemRepository.findById(anyLong())).thenReturn(Optional.of(todoItem));
        doNothing().when(todoItemRepository).delete(any(TodoItem.class));

        assertDoesNotThrow(() -> todoService.deleteTodoItem(1L));
        verify(todoItemRepository, times(1)).delete(todoItem);
    }

    @Test
    void getTodoItemById_NotFound() {
        when(todoItemRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> todoService.getTodoItemById(1L));
    }
}