package com.siemens.customerservice.services;

import com.siemens.customerservice.models.CorporateCustomer;
import com.siemens.customerservice.repositories.CorporateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorporateCustomerService extends GenericServiceImpl<CorporateCustomer> {
    @Autowired
    public CorporateCustomerService(CorporateRepository corporateRepository) {
        super(corporateRepository);

    }
}
