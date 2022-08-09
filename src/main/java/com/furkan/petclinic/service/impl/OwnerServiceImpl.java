package com.furkan.petclinic.service.impl;

import com.furkan.petclinic.dto.response.GetOwnerResponse;
import com.furkan.petclinic.dto.request.CreateOwnerRequest;
import com.furkan.petclinic.repository.OwnerRepository;
import com.furkan.petclinic.repository.entity.Owner;
import com.furkan.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;

    @Override
    public CreateOwnerRequest createOwner(CreateOwnerRequest createOwnerRequest) {
        Owner owner = modelMapper.map(createOwnerRequest, Owner.class);
        owner.setCreatedBy("admin");
        owner.setCreatedDate(new Date());
        return modelMapper.map(ownerRepository.save(owner),CreateOwnerRequest.class);
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
    public List<GetOwnerResponse> getOwners() {
        List <Owner> owners= ownerRepository.findAll();
        List <GetOwnerResponse> dtoOwner = owners.stream()
                .map(owner -> modelMapper.map(owner,GetOwnerResponse.class))
                .collect(Collectors.toList());
        return dtoOwner;
    }






}

