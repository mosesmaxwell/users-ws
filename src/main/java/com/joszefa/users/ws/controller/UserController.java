package com.joszefa.users.ws.controller;

import com.joszefa.users.ws.model.request.UpdateUserDetails;
import com.joszefa.users.ws.model.request.UserDetails;
import com.joszefa.users.ws.model.response.UserRest;
import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    private final WebSocketServletAutoConfiguration webSocketServletAutoConfiguration;
    Map<String, UserRest> users;

    public UserController(WebSocketServletAutoConfiguration webSocketServletAutoConfiguration) {
        this.webSocketServletAutoConfiguration = webSocketServletAutoConfiguration;
    }

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "count", defaultValue = "10") int count,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
    ) {
        return "All users!";
    }

    @GetMapping(path = "/{userId}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        if (users == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    }, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetails userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setUsername(userDetails.getUsername());
        returnValue.setPassword(userDetails.getPassword());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{userId}")
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetails userDetails) {
        UserRest returnValue = users.get(userId);
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        users.put(userId, returnValue);
        return returnValue;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity deleteUser(@PathVariable String userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
