package com.reservahotel.service;

import com.reservahotel.Dtos.UserDto;
import com.reservahotel.entities.Reserve;
import com.reservahotel.entities.User;
import com.reservahotel.repositories.UserRepository;
import com.reservahotel.service.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ReserveService reserveService;



    public void deleteUser(String userDocument) throws Exception {

        Optional<User> user= repository.findByDocument(userDocument);
        if (user.isEmpty()) {
            throw new ResourseNotFoundByDocumentException(userDocument);
        }
       User userIsTrue = user.get();
        List<Reserve> userReserve = user.get().getReserves();
        for (Reserve x : userReserve){
            reserveService.deleteById(x.getId());
        }
        repository.delete(userIsTrue);
        System.out.println("usuario deletado");
    }

    public List<User> findAll(){
        return repository.findAll();
   }

   public User findById(Long id)  {
      Optional<User> user = repository.findById(id);
      return user.orElseThrow(()-> new ResourseNotFoundByIdException(id));
   }

   public void deleteReserves(Long id) {
       reserveService.deleteById(id);
   }

    public User saveUser(User user) throws Exception {

        return repository.save(user);
    }
   public User createUser(String firstName, String lastName, String document, String email, String password) throws Exception {
    UserDto dto = new UserDto(firstName,lastName,document,email,password);
    User user=new User(dto);
        checkEmail(user.getEmail());
    checkDocument(user.getDocument());
    return this.saveUser(user);
   }


   public User findByDocument(String document){
        Optional<User> user =  repository.findByDocument(document);
        return user.orElseThrow(()->new ResourseNotFoundByDocumentException(document));
    }

    public User findByEmail(String email){
        Optional<User> user =  repository.findByDocument(email);
        return user.orElseThrow(()->new ResourseNotFoundByEmailException(email));
    }

    public void checkEmail(String email){
        User userByEmail = this.findByEmail(email);
        if(userByEmail != null ){
            throw new UserWhithEmailAlreadyRegisterException(email);
        }
    }

    public void checkDocument(String document){
        User userByDocument = this.findByDocument(document);
        if(userByDocument != null ){
            throw new UserWhithDocumentAlreadyRegisterException(document);
        }

    }


   }



