package com.tourism.nomadslog.controller;

import com.tourism.nomadslog.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tourism.nomadslog.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> signup(@RequestBody User user) {
     User useradd = userService.createUser(user);
    userService.save(useradd);
     return new ResponseEntity<>(user.getId(),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsers(@PathVariable ObjectId id) {
     User uss =  userService.getUserById(id);
      return new ResponseEntity<>(uss,HttpStatus.FOUND);
    }

}