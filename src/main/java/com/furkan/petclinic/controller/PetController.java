package com.furkan.petclinic.controller;

import com.furkan.petclinic.repository.entity.Pet;
import com.furkan.petclinic.service.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pet")
@Api(value = "Pet Controller")
public class PetController {

    private final PetService petService;

    @PostMapping("/createpet")
    @ApiOperation("/save pet")
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet){
        Pet resultPet= petService.createPet(pet);
        return ResponseEntity.ok(resultPet);
    }
    @PostMapping("/getpet")
    @ApiOperation("/get pet")
    public ResponseEntity<List<Pet>> getPet(){
        List<Pet> resultPet= petService.getPet();
        return ResponseEntity.ok(resultPet);
    }
}
