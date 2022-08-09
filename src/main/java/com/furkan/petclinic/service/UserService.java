package com.furkan.petclinic.service;

import com.furkan.petclinic.dto.request.CreateOwnerRequest;
import com.furkan.petclinic.dto.request.CreateUserRequest;
import com.furkan.petclinic.dto.response.GetUserResponse;

import java.util.List;

public interface UserService {
    CreateUserRequest createUser(CreateUserRequest createUserRequest);
    CreateUserRequest updateUser(Long id, CreateUserRequest createUserRequest);
    Boolean deleteUser(Long id);
    List<GetUserResponse> getUsers();

}
