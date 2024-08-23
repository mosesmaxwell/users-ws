package com.joszefa.users.ws.userservice;

import com.joszefa.users.ws.model.request.UpdateUserDetails;
import com.joszefa.users.ws.model.request.UserDetails;
import com.joszefa.users.ws.model.response.UserRest;

import java.util.Map;

public interface UserService {
    Map<String, UserRest> getUsers(int page, int count, String sort);

    UserRest getUser(String userId);

    UserRest createUser(UserDetails userDetails);

    UserRest updateUser(String userId, UpdateUserDetails userDetails);

    void deleteUser(String userId);
}
