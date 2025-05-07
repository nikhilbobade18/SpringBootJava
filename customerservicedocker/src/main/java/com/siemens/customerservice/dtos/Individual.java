package com.siemens.customerservice.dtos;

import com.siemens.customerservice.models.Customer;
import com.siemens.customerservice.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Individual extends Customer {
    private Gender gender;
    private LocalDate dateOfBirth;
}
