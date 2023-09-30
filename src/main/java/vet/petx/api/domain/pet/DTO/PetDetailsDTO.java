package vet.petx.api.domain.pet.DTO;

import vet.petx.api.domain.pet.Pet;
import vet.petx.api.domain.pet.enums.Species;
import vet.petx.api.domain.petOwner.PetOwner;

public record PetDetailsDTO(
        Long id,
        String name,
        Species species,
        Integer age,
        String breed,
        PetOwner petOwner) {

    public PetDetailsDTO(Pet pet){
        this(
                pet.getId(),
                pet.getName(),
                pet.getSpecies(),
                pet.getAge(),
                pet.getBreed(),
                pet.getPetOwner()
        );
    }
}
