package com.project.matzip.controllers;

import com.project.matzip.entities.Comment;
import com.project.matzip.entities.Restaurant;
import com.project.matzip.entities.Role;
import com.project.matzip.entities.User;
import com.project.matzip.pojos.UserRegistration;
import com.project.matzip.repository.RestaurantRepository;
import com.project.matzip.service.CommentService;
import com.project.matzip.service.RestaurantService;
import com.project.matzip.service.RoleService;
import com.project.matzip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CommentService commentService;


    @GetMapping(value = "/users")
    public List<User> users() {
        return userService.getAllUsers();

    }
    
    

    // 식당 등록
    @PostMapping(value = "/restPost")
    public String restPost(@RequestBody Restaurant rest) {
//        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//
//        rest.setCreator(restaurantService.getUser(loggedInUser.getName()));

        if (restaurantService.findByRestId(rest.getRestId()) == null) {
            restaurantService.insert(rest);
        }

//        else {
//            restaurantService.modify(rest);
//        }


        return "Restaurant added";



    }

//    @PostMapping(value = "/restpost/joinpage")
//    public String joinPage(@RequestBody User user) {
//
//        if (userService.getUser(user.getUserName()) != null) {
//            return "user already exists";
//        } else {
//            userService.save(user);
//            return "user created";
//        }
//
//    }


    // 회원등록
    @PostMapping(value = "/joinpage")
    public String joinPage(@RequestBody UserRegistration userRegistration) {
        if(!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation())) {
            return "Passwords do not match";
        }
        else if(userService.getUser(userRegistration.getName()) != null) {
            return "User already exists";
        }

        // input user

        userService.save(new User(userRegistration.getName(),
                userRegistration.getEmail(), userRegistration.getPassword(), userRegistration.getPhone(),
                new HashSet<Role>(Arrays.asList(roleService.getRole("USER")))));

        return "User created";
    }


    // 댓글 등록
    @PostMapping(value = "/postcomment")
    public String postComment(@RequestBody Comment comment) {

        commentService.insert(comment);
        restaurantService.insertComment(comment);
        return "comment added";
    }

    // 식당 불러오기
    @GetMapping(value = "/restaurants")
    public List<Restaurant> restaurants() {
        return restaurantService.getAllRestaurants();
    }

    // 사진 업로드







}
