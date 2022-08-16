package com.furkan.petclinic.dto.response;

import lombok.Data;

@Data
public class GetUserResponse {
    private String userName;
    private String userSurname;
    private long userId;
}
