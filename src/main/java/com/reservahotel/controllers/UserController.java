package com.reservahotel.controllers;

import com.reservahotel.Dtos.UserDto;
import com.reservahotel.entities.User;
import com.reservahotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
UserService service;

    @PostMapping(value= "/save")
    public ResponseEntity<User> save(@RequestBody String firstName, String lastName, String document, String email, String password) throws Exception {
        User obj = service.createUser(firstName,lastName,document,email,password);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);

    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id)   {
        User userById = service.findById(id);
        return ResponseEntity.ok().body(userById);
    }

    @DeleteMapping(value="/delete")
    public ResponseEntity<String> deleteUser(@RequestBody Map<String, String> requestBody) throws Exception {
        String document = requestBody.get("document");
        service.deleteUser(document);
        return ResponseEntity.ok().body("Usuario deletado");
    }
        }



