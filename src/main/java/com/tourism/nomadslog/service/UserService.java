package com.tourism.nomadslog.service;

import com.tourism.nomadslog.entity.User;
import com.tourism.nomadslog.repository.TravelAnalysisRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourism.nomadslog.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User save(User user) {
        return userRepository.save(user);
    }

    public User createUser(User user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        return newUser;
    }

    public User getUserById(ObjectId id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id.toString()));
    }
    //TRAVEL STATS PER USER


}
