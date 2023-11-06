package com.epam.upskil.repository;

import com.epam.upskil.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @className: TodoItemRepository  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 2:45 PM 48 $
 * @author: Qudratjon Komilov
 */
@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    // CRUD operations are provided by JpaRepository
}
