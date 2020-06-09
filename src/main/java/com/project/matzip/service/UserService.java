package com.project.matzip.service;

import com.project.matzip.entities.User;
import com.project.matzip.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository repo;

    public List<User> getAllUsers() {
        return repo.findAll();
    }


    public User getUser(String username) {
        return repo.findByUserName(username);
    }

    public void save(User user) {
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        repo.save(user);
    }

    private PasswordEncoder getPasswordEncoder() {

        return new PasswordEncoder() {

            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                // TODO Auto-generated method stub

                System.out.println(rawPassword);
                System.out.println(encodedPassword);

                return encode(rawPassword).equals(encodedPassword);
            }
        };
    }
}