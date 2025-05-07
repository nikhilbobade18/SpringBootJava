package com.siemens.customerservice.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "individual_customer")
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualCustomer extends Customer implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender",nullable = false,length = 15)
    private Gender gender;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "Date_Of_Birth",nullable = false)
    private LocalDate dateOfBirth;
}
