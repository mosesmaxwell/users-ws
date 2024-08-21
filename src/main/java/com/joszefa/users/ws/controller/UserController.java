package com.joszefa.users.ws.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "count", defaultValue = "10") int count,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
    ) {
        return "Get method called with page = " + page + ", count = " + count + ", sort = " + sort;
    }

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable String userId) {
        return "Get method called! " + userId;
    }

    @PostMapping
    public String postUsers() {
        return "Post method called!";
    }

    @PutMapping
    public String putUsers() {
        return "Put method called!";
    }

    @DeleteMapping
    public String deleteUsers() {
        return "Delete method called!";
    }
}
