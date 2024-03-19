package com.reservahotel.service;

import com.reservahotel.domain.entities.Reserve;
import com.reservahotel.domain.entities.User;
import com.reservahotel.repositories.UserRepository;
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

    public User saveUser(User user) throws Exception {

        Optional<User> document= repository.findByDocument(user.getDocument());
        if (document.isPresent()) {
            throw new Exception("CPF JA CADASTRADO");
        }
        Optional<User> email= repository.findByEmail(user.getEmail());
        if (email.isPresent()) {
            throw new Exception("EMAIL JA CADASTRADO");
        }
        return repository.save(user);
    }

    public void deleteUser(String userDocument) throws Exception {

        Optional<User> user= repository.findByDocument(userDocument);
        if (user.isEmpty()) {
            throw new Exception("USUARIO NÃO ENCONTRADO");
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

   public User findById(Long id){
      Optional<User> user = repository.findById(id);
        return user.get();
   }

   public void deleteReserves(Long id) {
       reserveService.deleteById(id);
   }
   }



