package com.example.springcruddemo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    // http://localhost:8081/api/v1/users
    @GetMapping("/users")
    public List<UserEntity> findUsers() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.create(user);

    }
    @PutMapping("/user/{id}")
    public UserEntity updateUser(@PathVariable String id, @RequestBody UserEntity user) {
        System.out.println(id);
        return userService.update(id, user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable String id) {
        return userService.delete(id);
    }

   
}

    

