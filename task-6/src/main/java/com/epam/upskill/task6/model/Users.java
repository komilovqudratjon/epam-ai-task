package com.epam.upskill.task6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @className: Actor  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 5:47 PM 40 $
 * @author: Qudratjon Komilov
 */
@Document(collection = "actors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    private String id;
    private String name;
    private String type;
}
