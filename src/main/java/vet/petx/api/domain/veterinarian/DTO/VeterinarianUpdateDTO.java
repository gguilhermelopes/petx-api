package vet.petx.api.domain.veterinarian.DTO;

import jakarta.validation.constraints.NotNull;
import vet.petx.api.domain.address.AddressDataDTO;

public record VeterinarianUpdateDTO(
        String phone,
        String name,
        AddressDataDTO address,
        Boolean active
) {


    public boolean areAllPropertiesNull() {
        return name == null && phone == null && address == null && active == null;
    }
}
