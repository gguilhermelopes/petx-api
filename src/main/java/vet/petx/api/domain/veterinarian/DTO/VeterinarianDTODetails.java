package vet.petx.api.domain.veterinarian.DTO;

import vet.petx.api.domain.address.AddressData;
import vet.petx.api.domain.veterinarian.Veterinarian;
import vet.petx.api.domain.veterinarian.enums.Specialization;

public record VeterinarianDTODetails(
        Long id,
        String name,
        String email,
        String crmv,
        String phone,
        Specialization specialization,
        AddressData address) {
    public VeterinarianDTODetails(Veterinarian veterinarian){
        this(
                veterinarian.getId(),
                veterinarian.getName(),
                veterinarian.getEmail(), veterinarian.getCrmv(),
                veterinarian.getPhone(),
                veterinarian.getSpecialization(),
                veterinarian.getAddress()
        );
    }
}
