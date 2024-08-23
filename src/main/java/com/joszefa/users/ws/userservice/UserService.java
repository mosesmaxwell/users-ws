package com.joszefa.users.ws.userservice;

import com.joszefa.users.ws.model.request.UpdateUserDetails;
import com.joszefa.users.ws.model.request.UserDetails;
import com.joszefa.users.ws.model.response.Users;

import java.util.List;

public interface UserService {
    List<Users> getUsers(int page, int count, String sort);

    Users getUser(String userId);

    Users createUser(UserDetails userDetails);

    Users updateUser(String userId, UpdateUserDetails userDetails);

    void deleteUser(String userId);
}
