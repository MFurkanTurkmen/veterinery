package com.furkan.petclinic.service;

import com.furkan.petclinic.repository.entity.Owner;
import jdk.jfr.Category;

import java.util.List;

public interface OwnerList {
    List<Owner> findByOwnerId(Long id);
}
