package vet.petx.api.domain.petOwner.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import vet.petx.api.domain.address.AddressDataDTO;

public record PetOwnerInsertDTO(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cpf,
        @NotNull
        @Valid
        AddressDataDTO address
        ) {
}
