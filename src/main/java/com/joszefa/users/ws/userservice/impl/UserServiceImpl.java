package com.joszefa.users.ws.userservice.impl;

import com.joszefa.users.ws.model.request.UpdateUserDetails;
import com.joszefa.users.ws.model.request.UserDetails;
import com.joszefa.users.ws.model.response.UserRest;
import com.joszefa.users.ws.shared.Utils;
import com.joszefa.users.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public Map<String, UserRest> getUsers(int page, int size, String sort) {
        return users;
    }

    @Override
    public UserRest getUser(String userId) {
        return users.get(userId);
    }

    @Override
    public UserRest createUser(UserDetails userDetails) {

        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setUsername(userDetails.getUsername());
        returnValue.setPassword(userDetails.getPassword());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }

    @Override
    public UserRest updateUser(String userId, UpdateUserDetails userDetails) {
        UserRest returnValue = users.get(userId);
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        users.put(userId, returnValue);
        return returnValue;
    }

    @Override
    public void deleteUser(String userId) {
        users.remove(userId);
    }
}
