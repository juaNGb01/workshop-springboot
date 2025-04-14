package com.myapp.demo.services;

import com.myapp.demo.entities.Order;
import com.myapp.demo.entities.User;
import com.myapp.demo.repositories.OrderItemRepository;
import com.myapp.demo.repositories.OrderRepository;
import com.myapp.demo.repositories.UserRepository;
import com.myapp.demo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public List<User> findAll(){
        return  repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void deleteById(Long id){
        repository.deleteById(id);

    }

    public User update(Long id, User obj){
        User user = repository.getById(id);
        updateData(user, obj);
        return repository.save(user);
    }

    private void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());
    }

}
