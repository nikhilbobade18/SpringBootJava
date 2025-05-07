package com.siemens.customerservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ResponseWrapper<T> {

    private T data;
    private String message;

    public ResponseWrapper(T data) {
        this.data = data;
    }

    public ResponseWrapper(String message) {
        this.message = message;
    }
}
