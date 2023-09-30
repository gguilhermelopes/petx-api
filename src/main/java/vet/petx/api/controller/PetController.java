package vet.petx.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vet.petx.api.domain.pet.DTO.PetDetailsDTO;
import vet.petx.api.domain.pet.DTO.PetInsertDTO;
import vet.petx.api.domain.pet.DTO.PetUpdateDTO;
import vet.petx.api.domain.pet.PetRepository;
import vet.petx.api.domain.pet.PetService;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService service;

    @PostMapping
    @Transactional
    public ResponseEntity<PetDetailsDTO> insert(@RequestBody @Valid PetInsertDTO obj, UriComponentsBuilder uriComponentsBuilder){
        PetDetailsDTO pet = new PetDetailsDTO(service.insert(obj));

        URI uri = uriComponentsBuilder.path("/pets/{id}")
                .buildAndExpand(pet.id()).toUri();

        return ResponseEntity.created(uri).body(pet);
    }

    @GetMapping
    public ResponseEntity<List<PetDetailsDTO>> list(){

        return ResponseEntity.ok().body(service.listAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PetDetailsDTO> listById(@PathVariable Long id){


        return ResponseEntity.ok().body(service.FindBydId(id));
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<PetDetailsDTO> update(@PathVariable Long id, @RequestBody @Valid PetUpdateDTO obj){

        return ResponseEntity.ok().body(service.update(id, obj));
    }
}
