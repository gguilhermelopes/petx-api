package vet.petx.api.domain.pet.DTO;

import vet.petx.api.domain.pet.enums.Species;

public record PetUpdateDTO(
        String name,
        Species species,
        Integer age,
        String breed,
        Long weight
) {

    public boolean areAllPropertiesNull() {
        return name == null && species == null && age == null && breed == null && weight == null;
    }
}
