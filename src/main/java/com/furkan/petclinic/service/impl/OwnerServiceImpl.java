package com.furkan.petclinic.service.impl;
import com.furkan.petclinic.repository.OwnerRepository;
import com.furkan.petclinic.repository.entity.Owner;
import com.furkan.petclinic.service.OwnerService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {


    private final OwnerRepository ownerRepository;

    @Override
    public Owner createUser(Owner owner) {
        owner.setCreatedDate(new Date());
        owner.setCreatedBy("admin");
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }


}

