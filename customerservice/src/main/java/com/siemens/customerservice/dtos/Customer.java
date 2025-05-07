package com.siemens.customerservice.dtos;

import com.siemens.customerservice.models.FullName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Customer {
    private String customerId;


    private FullNameDTO fullName;


    private String email;


    private String phoneNumber;

    private boolean active;
}
