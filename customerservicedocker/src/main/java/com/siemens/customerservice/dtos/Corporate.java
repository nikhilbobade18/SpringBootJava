package com.siemens.customerservice.dtos;

import com.siemens.customerservice.models.CompanyType;
import com.siemens.customerservice.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Corporate extends Customer {
    private CompanyType companyType;
}
