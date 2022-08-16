package com.furkan.petclinic.service.impl;

import com.furkan.petclinic.dto.request.CreatePetRequest;
import com.furkan.petclinic.dto.response.GetOwnerNameResponse;
import com.furkan.petclinic.dto.response.GetOwnerResponse;
import com.furkan.petclinic.dto.request.CreateOwnerRequest;
import com.furkan.petclinic.repository.OwnerRepository;
import com.furkan.petclinic.repository.entity.Owner;
import com.furkan.petclinic.repository.entity.Pet;
import com.furkan.petclinic.service.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;
    public OwnerServiceImpl(OwnerRepository ownerRepository, ModelMapper modelMapper) {
        this.ownerRepository = ownerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CreateOwnerRequest createOwner(CreateOwnerRequest createOwnerRequest) {
        Owner owner = modelMapper.map(createOwnerRequest, Owner.class);
        owner.setCreatedDate(new Date());
        owner.setCreatedBy("admin");
        return modelMapper.map(ownerRepository.save(owner), CreateOwnerRequest.class);

    }

    @Override
    public List<Owner> findall() {
        return ownerRepository.findAll();
    }

    @Override
    public CreateOwnerRequest updateOwner(Long id, CreateOwnerRequest createOwnerRequest) {
        Optional<Owner> resultOwner = ownerRepository.findById(id);

        if(resultOwner.isPresent()){
            resultOwner.get().setOwnerName(createOwnerRequest.getOwnerName());
            resultOwner.get().setOwnerSurname(createOwnerRequest.getOwnerSurname());
            resultOwner.get().setOwnerPhone(createOwnerRequest.getOwnerPhone());
            resultOwner.get().setOwnerAddress(createOwnerRequest.getOwnerAddress());
            resultOwner.get().setOwnerEmail(createOwnerRequest.getOwnerEmail());
            resultOwner.get().setUpdateDate(new Date());
            resultOwner.get().setUpdateBy("admin");
            return modelMapper.map(ownerRepository.save(resultOwner.get()), CreateOwnerRequest.class);
        }
        return null;
    }

    @Override
    public Boolean deleteOwner(Long id) {
        Optional<Owner> resultOwner= ownerRepository.findById(id);
        if(resultOwner.isPresent()){
            ownerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteOwnerr(long id) {
        Owner owner = ownerRepository.getOne(id);
        ownerRepository.deleteById(id);
    }

    @Override
    public Optional<Owner> findByOwnerEmailandOwnerPassword(String email, String password) {
        return ownerRepository.findOptionalByOwnerEmailAndOwnerPassword(email,password);
    }

    @Override
    public List<GetOwnerResponse> getOwners() {
        List <Owner> owners= ownerRepository.findAll();
        List <GetOwnerResponse> dtoOwner = owners.stream()
                .map(owner -> modelMapper.map(owner,GetOwnerResponse.class))
                .collect(Collectors.toList());
        return dtoOwner;
    }




    @Override
    public List<GetOwnerNameResponse> getOwnersName(String name) {
    List<Owner> owners= ownerRepository.findByOwnerNameStartingWith(name);
    List<GetOwnerNameResponse> dtoOwner= owners.stream()
            .map(owner -> modelMapper.map(owner,GetOwnerNameResponse.class))
            .collect(Collectors.toList());
    return dtoOwner;
    }



}

