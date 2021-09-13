package com.example.multipledatabasestest.services;

import com.example.multipledatabasestest.entities.mysql.User;
import com.example.multipledatabasestest.entities.redis.UserCached;
import com.example.multipledatabasestest.repositories.mysql.UserRepository;
import com.example.multipledatabasestest.repositories.redis.UserCachedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCachedRepository userCachedRepository;

    public void createUser(User user) {
        userRepository.save(user);

        UserCached userCached = new UserCached();
        userCached.setId(user.getEmail());
        userCached.setName(user.getName());
        userCached.setAge(user.getAge());

        userCachedRepository.save(userCached);
    }

    public User getUser(String email) {
        UserCached userCached = userCachedRepository.findById(email).orElseThrow(() -> new EntityNotFoundException());

        User user = new User();
        user.setEmail(userCached.getId());
        user.setAge(userCached.getAge());
        user.setName(userCached.getName());

        return user;
    }
}
