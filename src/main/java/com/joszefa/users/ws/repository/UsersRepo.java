package com.joszefa.users.ws.repository;

import com.joszefa.users.ws.model.response.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepo extends MongoRepository<Users, String> {
    Users findByUserId(String userId);
    void deleteByUserId(String userId);
}
