package com.project.matzip.service;

import com.project.matzip.entities.Comment;
import com.project.matzip.entities.Restaurant;
import com.project.matzip.repository.CommentRepository;
import com.project.matzip.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepo;



    public void insert(Comment comment) {
        commentRepo.save(comment);
    }
}
