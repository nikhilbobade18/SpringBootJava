package com.siemens.models;

import com.siemens.facades.DataSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Component
public class ServicePoint {

    private RestTemplate restTemplateObject;
    @Autowired
    public ServicePoint(RestTemplate restTemplate) {
        this.restTemplateObject = restTemplate;
    }

    public String getAllUsers(){
        return restTemplateObject.getForObject("https://jsonplaceholder.typicode.com/users", String.class);
    }



}
