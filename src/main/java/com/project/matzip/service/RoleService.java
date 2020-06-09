package com.project.matzip.service;

import com.project.matzip.entities.Role;
import com.project.matzip.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repo;

    public Role getRole(String role) { return repo.findByRole(role); }

}