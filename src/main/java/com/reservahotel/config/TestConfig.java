package com.reservahotel.config;

import com.reservahotel.domain.entities.User;
import com.reservahotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        User u1 = new User("leandro","aliano","1234","leandro.email.com","1234");
        userRepository.save(u1);
    }
}
