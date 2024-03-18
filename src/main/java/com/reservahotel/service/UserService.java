package com.reservahotel.service;

import com.reservahotel.domain.entities.User;
import com.reservahotel.repositories.UserRepository;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

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

   public User findById(Long id){
      Optional<User> user = repository.findById(id);
        return user.get();
   }



}
