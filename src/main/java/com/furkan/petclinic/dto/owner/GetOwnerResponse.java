package com.furkan.petclinic.dto.owner;

import lombok.Data;

@Data
public class GetOwnerResponse {
    private String ownerName;
    private String ownerSurname;
    private String ownerEmail;
    private String ownerPhone;


}