package com.epam.upskill.task4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @className: ResourceNotFoundException  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 4:31 PM 39 $
 * @author: Qudratjon Komilov
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
