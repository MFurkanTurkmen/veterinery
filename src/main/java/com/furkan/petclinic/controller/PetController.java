package com.furkan.petclinic.controller;

import com.furkan.petclinic.dto.request.CreatePetRequest;
import com.furkan.petclinic.dto.response.GetOwnerNameResponse;
import com.furkan.petclinic.dto.response.GetPetNameResponse;
import com.furkan.petclinic.dto.response.GetPetResponse;
import com.furkan.petclinic.service.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pet")
@Api(value = "pet controller")
public class PetController {

    private final PetService petService;

    @ApiOperation(value = "/create pate")
    @PostMapping("/createpet")
    public ResponseEntity<CreatePetRequest> createPet(@RequestBody CreatePetRequest createPetRequest){
        CreatePetRequest resultPet= petService.createPet(createPetRequest);
        return ResponseEntity.ok(resultPet);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation(value = "update pet")
    public ResponseEntity<CreatePetRequest> updatePet(@PathVariable("id") Long id, @RequestBody CreatePetRequest createPetRequest){
        CreatePetRequest resultPet= petService.updatePet(id , createPetRequest);
        return ResponseEntity.ok(resultPet);
    }

    @DeleteMapping("/edit/{id}")
    @ApiOperation(value = "delete pet")
    public ResponseEntity<Boolean> deletePet(@PathVariable("id") Long id){
        Boolean status= petService.deletePet(id);
        return ResponseEntity.ok(status);
    }

    @ApiOperation(value = "get pet")
    @GetMapping("getpet")
    public ResponseEntity<List<GetPetResponse>> getPet(){
        List<GetPetResponse> resultPet= petService.getPet();
        return ResponseEntity.ok(resultPet);
    }

    public ResponseEntity<List<GetPetNameResponse>> getPetName(String name){
        List<GetPetNameResponse> resultPet= petService.getPetName(name);
        return ResponseEntity.ok(resultPet);
    }


}