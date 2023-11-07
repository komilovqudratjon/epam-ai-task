package com.epam.upskill.task4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @className: Genre  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 2:46 AM 13 $
 * @author: Qudratjon Komilov
 */
@Entity
@Table(name = "genres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Assuming one genre can include many books
    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private Set<Book> books;

}
