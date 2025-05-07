package com.siemens.facades;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class MySQLDS implements DataSource{
    @Override
    public String writeData(String data) {
        return new Faker().internet().emailAddress();
    }
}
