package com.kredx.Kredx.controller;

import com.kredx.Kredx.dto.UserEntityDto;
import com.kredx.Kredx.payload.ApiResponse;
import com.kredx.Kredx.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userEntity")
public class UserEntityController {

    @Autowired
    private UserEntityService userEntityService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserEntityDto userEntityDto,
                                                  @RequestParam(name = "roleId", required = false) int roleId
                                                  ){
        UserEntityDto user = this.userEntityService.createUser(userEntityDto, roleId);
        ApiResponse build = ApiResponse.builder().message("User-Create").status(true).data(user).controllerName("UserEntityController").build();
        return new ResponseEntity<>(build, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable("userId") int userId){
        UserEntityDto userById = this.userEntityService.getUserById(userId);
        ApiResponse build = ApiResponse.builder().message("Get user byId").status(true).data(userById).controllerName("UserEntityController").build();
        return new ResponseEntity<>(build, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllUser(){
        List<UserEntityDto> allUsers = this.userEntityService.getAllUsers();
        ApiResponse build = ApiResponse.builder().message("Get All Users").status(true).data(allUsers).controllerName("UserEntityController").build();
        return new ResponseEntity<>(build, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserEntityDto user) {
        // Implement signup logic using userService
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntityDto user) {
        // Implement login logic using userService and manage tokens
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        // Implement logout logic
    }

}
