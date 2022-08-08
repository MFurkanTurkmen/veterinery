package com.furkan.petclinic.dto.request;

import lombok.Data;

@Data
public class CreateOwnerRequest {

    private String ownerName;
    private String ownerSurname;
    private String ownerAddress;
    private String ownerEmail;
    private String ownerPhone;

}
