package com.User.Controller;

import com.User.Entity.User;
import com.User.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

@PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
    User user1 = userService.saveUser(user);
    return new ResponseEntity<>(user1, HttpStatus.CREATED);
   }
   @GetMapping
   public ResponseEntity<List<User>> getAllUsers(){
       List<User> allUsers = userService.getAllUsers();
       return new ResponseEntity<>(allUsers, HttpStatus.OK);

   }
@GetMapping("/{userId}")
   public ResponseEntity<User> getUserById(@PathVariable String userId){
       User userById = userService.getUserById(userId);
       return new ResponseEntity<>(userById, HttpStatus.OK);
   }



}
