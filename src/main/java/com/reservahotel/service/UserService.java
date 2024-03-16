package com.reservahotel.service;

import com.reservahotel.domain.entities.User;
import com.reservahotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }

    public List<User> findAll(){
        return repository.findAll();
   }
}
