package vet.petx.api.domain.petOwner.DTO;

import vet.petx.api.domain.address.AddressDataDTO;

public record PetOwnerUpdateDTO(
        String name,
        String email,
        String cpf,
        AddressDataDTO address,
        Boolean active
) {
    public boolean areAllPropertiesNull() {
        return name == null && email == null && cpf == null && address == null && active == null;
    }
}
