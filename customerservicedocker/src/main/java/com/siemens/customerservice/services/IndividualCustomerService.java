package com.siemens.customerservice.services;

import com.siemens.customerservice.models.IndividualCustomer;
import com.siemens.customerservice.repositories.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualCustomerService extends GenericServiceImpl<IndividualCustomer> {
    @Autowired
    public IndividualCustomerService(IndividualRepository individualRepository) {
        super(individualRepository);
    }
}
