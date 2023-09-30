package vet.petx.api.domain.petOwner.DTO;

import jakarta.validation.constraints.NotNull;
import vet.petx.api.domain.address.AddressDataDTO;

public record PetOwnerUpdateDTO(
        String name,
        String email,
        String cpf,
        AddressDataDTO address,
        Boolean active
) {
    public boolean allPropertiesAreNull() {
        return name == null && email == null && cpf == null && address == null && active == null;
    }
}
