package com.siemens.customerservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customer")
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "custom_id_generator")
    @GenericGenerator(name = "custom_id_generator", strategy = "com.siemens.customerservice.models.CustomIdGenerator")
    @Column(name = "Customer_Id")
    private String customerId;

    @Embedded
    private FullName fullName;

    @Column(name = "Email",nullable = false,length = 150)
    private String email;

    @Column(name = "Phone_Number",nullable = false,length = 15)
    private String phoneNumber;
    @Column(name = "Active",nullable = false)
    private boolean active;

}
