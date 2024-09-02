package com.reservahotel.repositories;

import com.reservahotel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
 public Optional<User> findByDocument(String document);
    public Optional<User> findByEmail(String email);

    public void deleteByDocument(String document);
}
