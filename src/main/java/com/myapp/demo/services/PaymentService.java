package com.myapp.demo.services;

import com.myapp.demo.entities.Payment;
import com.myapp.demo.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public List<Payment> findAll(){
        List<Payment> list = repository.findAll();
        return list;
    }

    public Payment findById(Long id){
        Optional<Payment> obj = repository.findById(id);
        return obj.get();
    }



}
