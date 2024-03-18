package com.reservahotel.controllers;

import com.reservahotel.domain.entities.Reserve;
import com.reservahotel.domain.entities.User;
import com.reservahotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
UserService service;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User obj){
        obj = service.saveUser(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);

    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User userById = service.findById(id);
        return ResponseEntity.ok().body(userById);
    }
        }



