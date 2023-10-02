package vet.petx.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vet.petx.api.domain.petOwner.DTO.PetOwnerDetailsDTO;
import vet.petx.api.domain.petOwner.DTO.PetOwnerInsertDTO;
import vet.petx.api.domain.petOwner.DTO.PetOwnerUpdateDTO;
import vet.petx.api.domain.petOwner.PetOwner;
import vet.petx.api.domain.petOwner.PetOwnerRepository;
import vet.petx.api.domain.petOwner.PetOwnerService;


import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pet_owners")
public class PetOwnerController {
    @Autowired
    private PetOwnerService service;

    @PostMapping
    @Transactional
    public ResponseEntity<PetOwnerDetailsDTO> insert(@RequestBody @Valid PetOwnerInsertDTO obj, UriComponentsBuilder uriComponentsBuilder) {
       PetOwnerDetailsDTO petOwner = service.insert(obj);

        URI uri = uriComponentsBuilder.path("/pet_owners/{id}").
                buildAndExpand(petOwner.id()).toUri();

        return ResponseEntity.created(uri).body(petOwner);

    }

    @GetMapping
    public ResponseEntity<List<PetOwnerDetailsDTO>> list(){

         return ResponseEntity.ok().body(service.listAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PetOwnerDetailsDTO> listById(@PathVariable Long id){

        return ResponseEntity.ok().body(service.FindBydId(id));
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<PetOwnerDetailsDTO> update(@PathVariable Long id, @RequestBody @Valid PetOwnerUpdateDTO obj){

        return ResponseEntity.ok().body(service.update(id, obj));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
