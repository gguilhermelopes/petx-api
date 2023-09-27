package vet.petx.api.domain.veterinarian.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import vet.petx.api.domain.address.AddressDataDTO;
import vet.petx.api.domain.veterinarian.enums.Specialization;

public record VeterinarianDTOInsert(

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crmv,
        @NotNull
        Specialization specialization,
        @NotNull
        @Valid
        AddressDataDTO address
) {

}
