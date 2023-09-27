package vet.petx.api.domain.veterinarian;

import vet.petx.api.domain.veterinarian.enums.Specialization;

public record VeterinarianDTOList(Long id, String name, String email, String crmv, Specialization specialization) {

    public VeterinarianDTOList(Veterinarian veterinarian){
        this(
                veterinarian.getId(),
                veterinarian.getName(),
                veterinarian.getEmail(),
                veterinarian.getCrmv(),
                veterinarian.getSpecialization()
        );
    }
}