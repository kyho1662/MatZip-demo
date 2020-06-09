package com.project.matzip.repository;


import com.project.matzip.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Restaurant findByRestId(int restid);
}
