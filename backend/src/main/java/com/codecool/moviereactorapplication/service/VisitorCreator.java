package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.entity.Visitor;
import com.codecool.moviereactorapplication.model.Gender;
import com.codecool.moviereactorapplication.repository.VisitorRepository;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class VisitorCreator {

    private final VisitorRepository visitorRepository;

    private final PasswordEncoder passwordEncoder;

    public VisitorCreator(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public void createAdmin() {
        Visitor admin = Visitor.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .email("admin@gmail.com")
                .firstname("Klari")
                .lastname("Tolnai")
                .gender(Gender.GENERAL)
                .roles(Arrays.asList("ROLE_ADMIN", "ROLE_USER"))
                .build();
        visitorRepository.save(admin);
    }

    public void createUser() {
        Visitor user = Visitor.builder()
                .username("user")
                .password(passwordEncoder.encode("user"))
                .email("user@gmail.com")
                .firstname("Dani")
                .lastname("Kovats D.")
                .gender(Gender.MAN)
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
        visitorRepository.save(user);
    }

}
