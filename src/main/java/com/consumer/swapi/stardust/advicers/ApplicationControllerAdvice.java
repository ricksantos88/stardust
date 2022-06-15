package com.consumer.swapi.stardust.advicers;

import com.consumer.swapi.stardust.domain.exception.ApiErrors;
import com.consumer.swapi.stardust.domain.exception.MovieSearchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResponseStatusException(ResponseStatusException responseStatusException) {
        return new ResponseEntity<>(new ApiErrors(responseStatusException), responseStatusException.getStatus());
    }

    @ExceptionHandler(MovieSearchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleBusinessException(MovieSearchException exception){
        return new ApiErrors(exception);
    }

}
