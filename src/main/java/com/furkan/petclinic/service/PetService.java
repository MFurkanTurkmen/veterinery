package com.furkan.petclinic.service;

import com.furkan.petclinic.dto.request.CreatePetRequest;
import com.furkan.petclinic.dto.response.GetPetNameResponse;
import com.furkan.petclinic.dto.response.GetPetResponse;
import com.furkan.petclinic.repository.entity.Pet;

import java.util.List;

public interface PetService {

    CreatePetRequest createPet(CreatePetRequest createPetRequest);

    List<GetPetResponse> getPet();
    List<Pet> findall();

    CreatePetRequest updatePet(Long id, CreatePetRequest createPetRequest);
    Boolean deletePet(Long id);

    void deletePett(long id);



    List<GetPetNameResponse> getPetName(String name);
}
