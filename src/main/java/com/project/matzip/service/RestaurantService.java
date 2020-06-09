package com.project.matzip.service;


import com.project.matzip.entities.Comment;
import com.project.matzip.entities.Restaurant;
import com.project.matzip.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restRepo;


    public Restaurant findByRestId(int restId) {
        return restRepo.findByRestId(restId);
    }

    public void insert(Restaurant rest) {
        restRepo.save(rest);
    }

    public List<Restaurant> getAllRestaurants() {
        return restRepo.findAll();
    }

    public void insertComment(Comment comment) {
        Restaurant commentedRest = restRepo.getOne(comment.getRestId());
        commentedRest.getComments().add(comment);
    }
}
