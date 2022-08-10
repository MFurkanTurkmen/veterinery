package com.furkan.petclinic.service.impl;

import com.furkan.petclinic.dto.request.CreatePetRequest;
import com.furkan.petclinic.dto.response.GetPetNameResponse;
import com.furkan.petclinic.dto.response.GetPetResponse;
import com.furkan.petclinic.repository.PetRepository;
import com.furkan.petclinic.repository.entity.Pet;
import com.furkan.petclinic.service.PetService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final ModelMapper modelMapper;


    @Override
    public CreatePetRequest createPet(CreatePetRequest createPetRequest) {
    Pet pet = modelMapper.map(createPetRequest, Pet.class);
    pet.setCreatedDate(new Date());
    pet.setCreatedBy("admin");
    return modelMapper.map(petRepository.save(pet), CreatePetRequest.class);
    }

    @Override
    public CreatePetRequest updatePet(Long id, CreatePetRequest createPetRequest) {
        Optional<Pet> resultPet= petRepository.findById(id);

        if (resultPet.isPresent()){
            resultPet.get().setPetName(createPetRequest.getPetName());
            resultPet.get().setPetAge(createPetRequest.getPetAge());
            resultPet.get().setPetType(createPetRequest.getPetType());
            resultPet.get().setPetFamily(createPetRequest.getPetFamily());
            resultPet.get().setUpdateDate(new Date());
            return modelMapper.map(petRepository.save(resultPet.get()),CreatePetRequest.class);
        }
        return null;

    }


    @Override
    public Boolean deletePet(Long id) {
        Optional<Pet> resultPet= petRepository.findById(id);
        if (resultPet.isPresent()){
            petRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<GetPetNameResponse> getPetName(String name) {
    List<Pet> pets= petRepository.findByPetNameStartingWith(name);
    List<GetPetNameResponse> dtoPet =pets.stream()
            .map(pet -> modelMapper.map(pet,GetPetNameResponse.class))
            .collect(Collectors.toList());
    return dtoPet;
    }

    @Override
    public List<GetPetResponse> getPet() {
        List<Pet> pets = petRepository.findAll();
        List<GetPetResponse> dtoPet = pets.stream()
                .map(pet -> modelMapper.map(pet,GetPetResponse.class))
                .collect(Collectors.toList());
        return dtoPet;
    }





}




