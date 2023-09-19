package vet.petx.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vet.petx.api.veterinarian.Veterinarian;
import vet.petx.api.veterinarian.VeterinarianDTO;
import vet.petx.api.veterinarian.VeterinarianRepository;

@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {
    @Autowired
    private VeterinarianRepository repository;

    @PostMapping
    @Transactional
    public void insert(@RequestBody VeterinarianDTO obj){
        repository.save(new Veterinarian(obj));
    }

}
