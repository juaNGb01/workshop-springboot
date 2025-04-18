package com.myapp.demo.services;

import com.myapp.demo.entities.Category;
import com.myapp.demo.repositories.CategoryRepository;
import com.myapp.demo.services.exceptions.DataBaseException;
import com.myapp.demo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

    public Category insert(Category category){
        return repository.save(category);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException e ){
            throw new DataBaseException(e.getMessage());
        }
    }

    public Category update(Long id, Category cat){
        try{
            Category obj = repository.getById(id);
            updateData(obj, cat);
            return repository.save(obj);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Category ogCategory, Category newCategory){
        ogCategory.setName(newCategory.getName());
    }
}
