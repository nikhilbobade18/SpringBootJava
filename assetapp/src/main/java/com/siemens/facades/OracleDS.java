package com.siemens.facades;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class OracleDS implements DataSource {
    @Override
    public String writeData(String data) {
        return new Faker().name().fullName();
    }
}
