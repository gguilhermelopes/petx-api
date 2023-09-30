package vet.petx.api.domain.pet.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import vet.petx.api.domain.pet.enums.Species;


public record PetInsertDTO(
        @NotBlank
        String name,
        @NotNull
        Species species,
        @NotNull
        Integer age,
        @NotBlank
        String breed,
        @NotNull
        Long weight,
        @NotNull
        Long petOwnerId
) {
}
