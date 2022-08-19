package com.furkan.petclinic.dto.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    Long userId;
    String userName;
    String userSurname;
    String userPhone;
    String userEmail;
    String userPassword;
}
