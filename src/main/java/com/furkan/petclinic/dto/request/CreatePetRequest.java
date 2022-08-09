package com.furkan.petclinic.dto.request;


import lombok.Data;


@Data
public class CreatePetRequest {
    private String petName;
    private String petType;
    private String petFamily;
    private Long petAge;


}
