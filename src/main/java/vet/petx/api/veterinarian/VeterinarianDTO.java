package vet.petx.api.veterinarian;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import vet.petx.api.address.AddressDataDTO;
import vet.petx.api.veterinarian.enums.Specialization;

public record VeterinarianDTO(

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
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
