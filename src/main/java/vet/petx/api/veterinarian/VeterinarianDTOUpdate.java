package vet.petx.api.veterinarian;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import vet.petx.api.address.AddressDataDTO;

public record VeterinarianDTOUpdate(
        @NotNull
        Long id,
        String phone,
        String name,
        AddressDataDTO address) {

}
