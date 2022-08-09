package com.furkan.petclinic.controller;


import com.furkan.petclinic.dto.request.CreateUserRequest;
import com.furkan.petclinic.dto.response.GetUserResponse;
import com.furkan.petclinic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "user contoller")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "create user")
    @PostMapping("/createuser")
    public ResponseEntity<CreateUserRequest> createUser(@RequestBody CreateUserRequest createUserRequest){
        CreateUserRequest resultUser = userService.createUser(createUserRequest);
        return ResponseEntity.ok(resultUser);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation(value = "update user")
    public ResponseEntity<CreateUserRequest> updateUser(@PathVariable ("id") Long id , @RequestBody CreateUserRequest createUserRequest){
        CreateUserRequest resultUser= userService.updateUser(id ,createUserRequest);
        return ResponseEntity.ok(resultUser);
    }
    @DeleteMapping("/edit/{id}")
    @ApiOperation(value = "delete user")
    public ResponseEntity<Boolean> deleteUser(@PathVariable ("id") Long id){
        Boolean status= userService.deleteUser(id);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/getuser")
    @ApiOperation(value = "get user")
    public ResponseEntity<List<GetUserResponse>> getUser(){
        List<GetUserResponse> resultUser =userService.getUsers();
        return ResponseEntity.ok(resultUser);
    }

}
