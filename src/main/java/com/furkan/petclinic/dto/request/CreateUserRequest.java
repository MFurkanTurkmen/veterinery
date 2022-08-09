package com.furkan.petclinic.dto.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    String userName;
    String userSurname;
    String userPhone;
}
