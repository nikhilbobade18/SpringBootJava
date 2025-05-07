package com.siemens;

import com.github.javafaker.Faker;
import com.siemens.models.Customer;
import com.siemens.models.ServicePoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;
@Configuration
public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new
                ClassPathXmlApplicationContext("asset-config.xml");
    //IOC
       // Customer customer = (Customer) context.getBean("customer");
        Customer customer = getCustomer();
    Faker faker = new Faker();
    //DI
    // customer.setId(faker.number().numberBetween(10000,10000000));
     //customer.setName(faker.name().fullName());
     customer.setAddress(faker.address().fullAddress());
     customer.setEmail(faker.internet().emailAddress());
     customer.setPhone(faker.phoneNumber().phoneNumber());

     //show customer data
        System.out.println(customer);

        ServicePoint servicePoint = context.getBean(ServicePoint.class);
       System.out.println(servicePoint.getAllUsers());

    }

    //java object converted to bean
    @Bean
    @Lazy
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Bean
    @Lazy
    public static Customer getCustomer() {
        Faker faker = new Faker();
        return new Customer(faker.number().numberBetween(10000,10000000),faker.name().fullName());
    }

}