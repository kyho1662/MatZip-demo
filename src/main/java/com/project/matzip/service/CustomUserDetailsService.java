package com.project.matzip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.matzip.entities.CustomUserDetails;
import com.project.matzip.entities.User;
import com.project.matzip.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUserName(username);

        if (user == null)
            throw new UsernameNotFoundException("Bad credentials!");

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(), // shall to be the already BCrypt-encrypted password
                new CustomUserDetails(user).getAuthorities());
    }
}
