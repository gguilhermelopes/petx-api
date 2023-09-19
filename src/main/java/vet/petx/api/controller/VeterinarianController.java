package vet.petx.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import vet.petx.api.veterinarian.Veterinarian;
import vet.petx.api.veterinarian.VeterinarianDTOInsert;
import vet.petx.api.veterinarian.VeterinarianDTOList;
import vet.petx.api.veterinarian.VeterinarianRepository;

import java.util.List;

@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {
    @Autowired
    private VeterinarianRepository repository;

    @PostMapping
    @Transactional
    public void insert(@RequestBody @Valid VeterinarianDTOInsert obj){
        repository.save(new Veterinarian(obj));
    }

    @GetMapping
    public Page<VeterinarianDTOList> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return repository.findAll(pageable).map(VeterinarianDTOList::new);
    }

}
