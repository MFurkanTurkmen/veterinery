package com.furkan.petclinic.service;

import com.furkan.petclinic.repository.entity.Pet;

import java.util.List;

public interface PetService {

    Pet createPet(Pet pet);

    List<Pet> getPet();
}
