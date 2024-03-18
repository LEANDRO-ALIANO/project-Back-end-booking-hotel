package com.reservahotel.config;

import com.reservahotel.domain.entities.Reserve;
import com.reservahotel.domain.entities.User;
import com.reservahotel.repositories.ReserveRepository;
import com.reservahotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReserveRepository reserveRepository;
    @Override
    public void run(String... args) throws Exception {

        User u1 = new User("leandro","aliano","1234","leandro.email.com","1234");
        userRepository.save(u1);
        Reserve r1 = new Reserve(LocalDate.now(),u1);
        Reserve r2 = new Reserve(LocalDate.now(),u1);
        Reserve r3 = new Reserve(LocalDate.now(),u1);
        reserveRepository.saveAll(Arrays.asList(r1,r2,r3));
    }
}
