package com.epam.upskil.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @className: ResourceNotFoundException  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 2:47 PM 49 $
 * @author: Qudratjon Komilov
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
