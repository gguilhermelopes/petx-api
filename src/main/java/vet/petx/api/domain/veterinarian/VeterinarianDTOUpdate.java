package vet.petx.api.domain.veterinarian;

import jakarta.validation.constraints.NotNull;
import vet.petx.api.domain.address.AddressDataDTO;

public record VeterinarianDTOUpdate(
        @NotNull
        Long id,
        String phone,
        String name,
        AddressDataDTO address) {

}
