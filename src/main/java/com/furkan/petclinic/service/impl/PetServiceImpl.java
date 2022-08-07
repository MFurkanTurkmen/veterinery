package com.furkan.petclinic.service.impl;

import com.furkan.petclinic.repository.PetRepository;
import com.furkan.petclinic.repository.entity.Pet;
import com.furkan.petclinic.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    @Override
    public Pet createPet(Pet pet) {
        pet.setCreatedDate(new Date());
        pet.setCreatedBy("admin");
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getPet() {
        return petRepository.findAll();

    }
}




