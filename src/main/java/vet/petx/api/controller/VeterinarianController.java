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
import vet.petx.api.domain.veterinarian.DTO.VeterinarianListDTO;
import vet.petx.api.domain.veterinarian.DTO.VeterinarianUpdateDTO;

import java.net.URI;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {
    @Autowired
    private VeterinarianRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<VeterinarianDetailsDTO> insert(
            @RequestBody @Valid VeterinarianInsertDTO obj,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Veterinarian vet = new Veterinarian(obj);
        repository.save(vet);

        URI uri = uriComponentsBuilder.path("/veterinarians/{id}").
                        buildAndExpand(vet.getId()).toUri();

        return ResponseEntity.created(uri).body(new VeterinarianDetailsDTO(vet));

    }

    @GetMapping
    public ResponseEntity<List<VeterinarianListDTO>> list() {
        List<VeterinarianListDTO> veterinarianList = repository.findAll()
                .stream()
                .filter(Veterinarian::getActive)
                .map(VeterinarianListDTO::new)
                .toList();

        return ResponseEntity.ok().body(veterinarianList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VeterinarianDetailsDTO> listById(@PathVariable Long id){
        Veterinarian vet = repository.getReferenceById(id);

        return ResponseEntity.ok().body(new VeterinarianDetailsDTO(vet));
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<VeterinarianDetailsDTO> update(@PathVariable Long id, @RequestBody @Valid VeterinarianUpdateDTO obj) {
        Veterinarian vet = repository.getReferenceById(id);
        vet.updateInfo(obj);

        return ResponseEntity.ok().body(new VeterinarianDetailsDTO(vet));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Veterinarian vet = repository.getReferenceById(id);
        vet.inactivateVet();

        return ResponseEntity.noContent().build();
    }
}
