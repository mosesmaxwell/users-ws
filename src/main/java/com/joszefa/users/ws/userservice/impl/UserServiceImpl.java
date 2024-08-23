package com.joszefa.users.ws.userservice.impl;

import com.joszefa.users.ws.model.request.UpdateUserDetails;
import com.joszefa.users.ws.model.request.UserDetails;
import com.joszefa.users.ws.model.response.Users;
import com.joszefa.users.ws.repository.UsersRepo;
import com.joszefa.users.ws.shared.Utils;
import com.joszefa.users.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    Utils utils;
    UsersRepo usersRepo;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils, UsersRepo usersRepo) {
        this.utils = utils;
        this.usersRepo = usersRepo;
    }

    @Override
    public List<Users> getUsers(int page, int size, String sort) {
        List<Users> users = usersRepo.findAll();
        return users;
    }

    @Override
    public Users getUser(String userId) {
        return usersRepo.findByUserId(userId);
    }

    @Override
    public Users createUser(UserDetails userDetails) {

        Users returnValue = new Users();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setUsername(userDetails.getUsername());
        returnValue.setPassword(userDetails.getPassword());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        usersRepo.save(returnValue);
        return returnValue;
    }

    @Override
    public Users updateUser(String userId, UpdateUserDetails userDetails) {
        Users existingUser = usersRepo.findByUserId(userId);
        System.out.println("User ID == " +existingUser.getUserId());
        existingUser.setFirstName(userDetails.getFirstName());
        existingUser.setLastName(userDetails.getLastName());
        usersRepo.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(String userId) {
        usersRepo.deleteByUserId(userId);
    }
}
