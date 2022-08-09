package com.furkan.petclinic.dto.response;

import lombok.Data;

@Data
public class GetPetResponse {
    private String petName;
    private String petType;
    private String petFamily;
    private Long petAge;
}
