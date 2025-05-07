package com.siemens.models;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Customer {
    @Getter
    private long id;
    @Getter
    private String name;
    @Setter
    @Getter
    private String address;
    @Setter
    @Getter
    private String phone;
    @Setter
    @Getter
    private String email;

    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
    }

}
