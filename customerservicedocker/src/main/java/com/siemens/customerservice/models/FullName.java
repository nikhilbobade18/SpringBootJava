package com.siemens.customerservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullName implements Serializable {
    @Column(name = "First_Name",nullable = false,length = 50)
    private String firstName;
    @Column(name = "Last_Name",nullable = false,length = 50)
    private String lastName;
    @Column(name = "Middle_Name",length = 50)
    private String middleName;
}
