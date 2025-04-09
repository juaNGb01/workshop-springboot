package com.myapp.demo.resources;

import com.myapp.demo.entities.Order;
import com.myapp.demo.entities.Payment;
import com.myapp.demo.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResources {

    @Autowired
    private PaymentService service;


    @GetMapping
    public ResponseEntity<List<Payment>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id){
        Payment obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }


}
