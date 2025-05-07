package com.siemens.customerservice.services;

public interface GenericService<T> {

    T save(T entity);
    T update(T entity);
    boolean delete(T entity);
    T findById(String id);
    Iterable<T> findAll();

}
