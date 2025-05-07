package com.siemens.customerservice.services;

import com.siemens.customerservice.controllers.CustomerController;
import com.siemens.customerservice.exceptions.CustomerNotFoundException;
import com.siemens.customerservice.repositories.BaseRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

//@Service
public abstract class GenericServiceImpl<T> implements GenericService<T> {
    //@Autowired
    private final BaseRepository<T,String> baseRepository;
   // private static final Logger logger = LogManager.getLogger(GenericServiceImpl.class);
    public GenericServiceImpl(BaseRepository<T,String> baseRepository) {
        this.baseRepository=baseRepository;
    }

    @Override
    //@Cacheable(cacheNames = "customersv2")
    public T save(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    //@CachePut(cacheNames = "customersv2")
    public T update(T entity) {
     return baseRepository.save(entity);
    }

    @Override
    //@CacheEvict(cacheNames = "customersv2")
    public boolean delete(T entity) {
      boolean status=false;
      if(entity!=null){
          baseRepository.delete(entity);
          status=true;
      }
      return status;
    }

    @Override
    public T findById(String id) {

        return baseRepository.findById(id).orElseThrow(()->
                new CustomerNotFoundException("Customer not found"));
    }

    @Override
    //@Cacheable(cacheNames = "customersv2")
    public Iterable<T> findAll() {
        /*logger.info("Starting customer process");
        logger.debug("Debugging details here");
        logger.warn("Warning: possible issue detected");*/
        return baseRepository.findAll();
    }
}
