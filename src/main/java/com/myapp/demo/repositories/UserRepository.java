package com.myapp.demo.repositories;

import com.myapp.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
