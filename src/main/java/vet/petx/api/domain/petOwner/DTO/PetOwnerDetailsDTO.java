package vet.petx.api.domain.petOwner.DTO;

import vet.petx.api.domain.address.AddressData;
import vet.petx.api.domain.petOwner.PetOwner;

public record PetOwnerDetailsDTO(
        Long id,
        String name,
        String email,
        String cpf,
        AddressData address,
        Boolean active
) {
    public PetOwnerDetailsDTO(PetOwner petOwner){
        this(petOwner.getId(),
        petOwner.getName(),
        petOwner.getEmail(),
        petOwner.getCpf(),
        petOwner.getAddress(),
        petOwner.getActive());
    }
}
