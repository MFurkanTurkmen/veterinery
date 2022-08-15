package com.furkan.petclinic.service.impl;

import com.furkan.petclinic.dto.request.CreateUserRequest;
import com.furkan.petclinic.dto.response.GetUserResponse;
import com.furkan.petclinic.repository.UserRepository;
import com.furkan.petclinic.repository.entity.User;
import com.furkan.petclinic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public CreateUserRequest createUser(CreateUserRequest createUserRequest) {
        User user=modelMapper.map(createUserRequest, User.class);
        user.setCreatedBy("admin");
        user.setCreatedDate(new Date());
        return modelMapper.map(userRepository.save(user),CreateUserRequest.class);
    }

    @Override
    public CreateUserRequest updateUser(Long id , CreateUserRequest createUserRequest){
        Optional<User> resultUser = userRepository.findById(id);

        if (resultUser.isPresent()){
            resultUser.get().setUserName(createUserRequest.getUserName());
            resultUser.get().setUserSurname(createUserRequest.getUserSurname());
            resultUser.get().setUserPhone(createUserRequest.getUserPhone());
            resultUser.get().setUpdateBy("admin");
            resultUser.get().setUpdateDate(new Date());
            return modelMapper.map(userRepository.save(resultUser.get()), CreateUserRequest.class);
        }
        return null;

    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> resultUser = userRepository.findById(id);
        if(resultUser.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<GetUserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        List<GetUserResponse> dtoUser= users.stream()
                .map(user -> modelMapper.map(user,GetUserResponse.class))
                .collect(Collectors.toList());
        return dtoUser;
    }

    @Override
    public List<User> findByUserId(Long id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public List<User> findall() {
        return userRepository.findAll();
    }
}
