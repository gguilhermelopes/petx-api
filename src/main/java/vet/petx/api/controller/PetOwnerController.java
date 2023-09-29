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



import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pet_owners")
public class PetOwnerController {
    @Autowired
    private PetOwnerRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<PetOwnerDetailsDTO> insert(
            @RequestBody @Valid PetOwnerInsertDTO obj,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        PetOwner petOwner = new PetOwner(obj);
        repository.save(petOwner);

        URI uri = uriComponentsBuilder.path("/pet_owners/{id}").
                buildAndExpand(petOwner.getId()).toUri();

        return ResponseEntity.created(uri).body(new PetOwnerDetailsDTO(petOwner));

    }

    @GetMapping
    public ResponseEntity<List<PetOwnerDetailsDTO>> list(){
        List<PetOwnerDetailsDTO> petOwnerList = repository.findAll()
                .stream()
                .filter(PetOwner::getActive)
                .map(PetOwnerDetailsDTO::new)
                .toList();

        return ResponseEntity.ok().body(petOwnerList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PetOwnerDetailsDTO> listById(@PathVariable Long id){
        PetOwner petOwner = repository.getReferenceById(id);

        return ResponseEntity.ok().body(new PetOwnerDetailsDTO(petOwner));
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<PetOwnerDetailsDTO> update(@PathVariable Long id, @RequestBody @Valid PetOwnerUpdateDTO obj){
        PetOwner petOwner = repository.getReferenceById(id);
        petOwner.updateInfo(obj);

        return ResponseEntity.ok().body(new PetOwnerDetailsDTO(petOwner));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        PetOwner petOwner = repository.getReferenceById(id);
        petOwner.inactivateVet();

        return ResponseEntity.noContent().build();
    }

}
