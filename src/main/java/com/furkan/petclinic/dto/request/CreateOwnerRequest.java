package com.furkan.petclinic.dto.request;

import com.furkan.petclinic.repository.entity.Owner;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateOwnerRequest {

    private String ownerName;
    private String ownerSurname;
    private String ownerAddress;
    private String ownerEmail;
    private String ownerPhone;

    private String ownerPassword;


}
