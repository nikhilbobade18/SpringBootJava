package com.siemens.customerservice.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@Table(name = "corporate_customer")
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateCustomer extends Customer implements Serializable {
    @Enumerated(EnumType.STRING)
    @Column(name = "CompanyType",nullable = false,length = 15)
    private CompanyType companyType;

}
