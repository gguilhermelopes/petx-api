package vet.petx.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;
import vet.petx.api.domain.veterinarian.*;
import vet.petx.api.domain.veterinarian.DTO.VeterinarianDetailsDTO;
import vet.petx.api.domain.veterinarian.DTO.VeterinarianInsertDTO;
import vet.petx.api.domain.veterinarian.DTO.VeterinarianUpdateDTO;

import java.net.URI;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {
    @Autowired
    private VeterinarianService service;

    @PostMapping
    @Transactional
    public ResponseEntity<VeterinarianDetailsDTO> insert(
            @RequestBody @Valid VeterinarianInsertDTO obj,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        VeterinarianDetailsDTO vet = service.insert(obj);

        URI uri = uriComponentsBuilder.path("/veterinarians/{id}").
                        buildAndExpand(vet.id()).toUri();

        return ResponseEntity.created(uri).body(vet);

    }

    @GetMapping
    public ResponseEntity<List<VeterinarianDetailsDTO>> list() {

        return ResponseEntity.ok().body(service.listAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VeterinarianDetailsDTO> listById(@PathVariable Long id){

        return ResponseEntity.ok().body(service.findBydId(id));
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<VeterinarianDetailsDTO> update(@PathVariable Long id, @RequestBody @Valid VeterinarianUpdateDTO obj) {

        return ResponseEntity.ok().body(service.update(id, obj));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
