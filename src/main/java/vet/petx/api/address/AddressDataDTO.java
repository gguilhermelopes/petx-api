package vet.petx.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDataDTO(
        @NotBlank
        String street,
        @NotBlank
        String district,
        @NotBlank
        @Pattern(regexp = "\\d{5}-\\d{3}|\\d{8}$")
        String cep,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        String number,
        String complement) {
}
