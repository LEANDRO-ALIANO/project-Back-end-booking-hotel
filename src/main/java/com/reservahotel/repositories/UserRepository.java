package com.reservahotel.repositories;

import com.reservahotel.domain.entities.Reserve;
import com.reservahotel.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

}
