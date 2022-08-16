package com.furkan.petclinic.dto.request;


import com.furkan.petclinic.repository.entity.Owner;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;


@Data
public class CreatePetRequest {
    private String petName;
    private String petType;
    private String petFamily;
    private Long petAge;

    @Id
    private Long ownerId;

}
