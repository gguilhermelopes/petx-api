package vet.petx.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vet.petx.api.veterinarian.VeterinarianDTO;

@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {

    @PostMapping
    public void insert(@RequestBody VeterinarianDTO obj){
        System.out.println(obj);
    }

}
