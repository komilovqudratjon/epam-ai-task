package com.epam.upskil.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @className: TodoItem  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 2:45 PM 20 $
 * @author: Qudratjon Komilov
 */
@Entity
@Table(name = "todo_items")
@Getter
@Setter
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;
}
