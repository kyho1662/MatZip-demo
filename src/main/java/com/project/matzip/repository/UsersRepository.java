package com.project.matzip.repository;

import com.project.matzip.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

    User findByUserName(String username);



}