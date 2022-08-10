package com.furkan.petclinic.dto.response;

import lombok.Data;

@Data
public class GetPetNameResponse {
    private String petName;
    private String petType;
    private String PetFamily;
    private Long petAge;

}
