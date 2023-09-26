package vet.petx.api.veterinarian;

import vet.petx.api.address.AddressData;
import vet.petx.api.veterinarian.enums.Specialization;

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
