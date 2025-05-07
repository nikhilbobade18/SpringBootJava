package com.siemens.customerservice.exceptions;

import com.siemens.customerservice.dtos.ResponseWrapper;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ResponseWrapper> handleCustomerNotFoundException(CustomerNotFoundException ex){
        return ResponseEntity.badRequest().body(new ResponseWrapper(ex.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public  ResponseEntity<ResponseWrapper> handleBadRequestException(BadRequestException ex){
        return ResponseEntity.badRequest().body(new ResponseWrapper(ex.getMessage()));
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseWrapper> handleRuntimeException(RuntimeException ex){
        return ResponseEntity.badRequest().body(new ResponseWrapper(ex.getMessage()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper> handleException(Exception ex){
        return ResponseEntity.badRequest().body(new ResponseWrapper(ex.getMessage()));
    }

}
