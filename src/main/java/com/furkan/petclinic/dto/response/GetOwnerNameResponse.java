package com.furkan.petclinic.dto.response;
import lombok.Data;

@Data
public class GetOwnerNameResponse {
    private String ownerName;
    private String ownerSurname;

}