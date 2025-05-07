package com.siemens.customerservice.controllers;

import com.siemens.customerservice.dtos.Corporate;
import com.siemens.customerservice.dtos.Individual;
import com.siemens.customerservice.dtos.ResponseWrapper;
import com.siemens.customerservice.models.CorporateCustomer;
import com.siemens.customerservice.models.FullName;
import com.siemens.customerservice.models.IndividualCustomer;
import com.siemens.customerservice.repositories.CorporateRepository;
import com.siemens.customerservice.services.CorporateCustomerService;
import com.siemens.customerservice.services.IndividualCustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private IndividualCustomerService individualCustomerService;
    @Autowired
    private CorporateCustomerService corporateCustomerService;

    private static final Logger logger = LogManager.getLogger(CustomerController.class);
    //save individual

    @PostMapping("/indvidualcustomers/v1.0")
    public ResponseEntity<ResponseWrapper> addIndividual(@RequestBody Individual individual){


        //DTO to Entity
        IndividualCustomer individualObj = IndividualCustomer.builder()
                .customerId(individual.getCustomerId())
                .fullName(FullName.builder()
                        .firstName(individual.getFullName().getFirstName())
                        .lastName(individual.getFullName().getLastName())
                        .middleName(individual.getFullName().getMiddleName())
                        .build())
                .email(individual.getEmail())
                .phoneNumber(individual.getPhoneNumber())
                .active(individual.isActive())
                .dateOfBirth(individual.getDateOfBirth())
                .gender(individual.getGender())
                .build();

         IndividualCustomer individualCustomerResponse= this.individualCustomerService.save(individualObj);
         if(individualCustomerResponse!=null){
             return ResponseEntity.status(HttpStatus.CREATED).body(new
                     ResponseWrapper<IndividualCustomer>(individualCustomerResponse));
         }else
         {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                     .body(new ResponseWrapper("Invalid Input"));
         }



    }
    @PostMapping("/corporatecustomers/v1.0")
    public ResponseEntity<ResponseWrapper> addCorporate(@RequestBody Corporate corporate){

        CorporateCustomer corporateObj = CorporateCustomer.builder()
                .customerId(corporate.getCustomerId())
                .fullName(FullName.builder()
                        .firstName(corporate.getFullName().getFirstName())
                        .lastName(corporate.getFullName().getLastName())
                        .middleName(corporate.getFullName().getMiddleName())
                        .build())
                .email(corporate.getEmail())
                .phoneNumber(corporate.getPhoneNumber())
                .companyType(corporate.getCompanyType())
                .active(corporate.isActive())

                .build();

        CorporateCustomer corporateCustomerResponse=
                this.corporateCustomerService.save(corporateObj);
        if(corporateCustomerResponse!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(new
                    ResponseWrapper<CorporateCustomer>(corporateCustomerResponse));
        }else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Invalid Input"));
        }



    }
    @GetMapping("/indvidualcustomers/v1.0/{customerId}")
    public ResponseEntity<ResponseWrapper> getCustomerById(@PathVariable String customerId) {
        IndividualCustomer individualCustomerResponse = this.individualCustomerService.findById(customerId);

        return ResponseEntity.status(HttpStatus.CREATED).body(new
                ResponseWrapper<IndividualCustomer>(individualCustomerResponse));

    }

    //get individuals
    @GetMapping("/indvidualcustomers/v1.0")
    @PreAuthorize("hasAuthority('SCOPE_Developer')")
    public Iterable<IndividualCustomer> getAllIndividuals(){
        logger.info("Starting customer process");
        logger.debug("Debugging details here");
        logger.warn("Warning: possible issue detected");
        return this.individualCustomerService.findAll();
    }

    @GetMapping("/corporatecustomers/v1.0")
    @PreAuthorize("hasAuthority('SCOPE_TEST')")
    public Iterable<CorporateCustomer> getAllCorporates(){
        logger.info("Starting customer process");
        logger.debug("Debugging details here");
        logger.warn("Warning: possible issue detected");
        return this.corporateCustomerService.findAll();
    }
}
