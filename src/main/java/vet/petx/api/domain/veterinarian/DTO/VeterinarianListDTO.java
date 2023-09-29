package vet.petx.api.domain.veterinarian.DTO;

import vet.petx.api.domain.veterinarian.Veterinarian;
import vet.petx.api.domain.veterinarian.enums.Specialization;

public record VeterinarianListDTO(Long id, String name, String email, String crmv, Specialization specialization) {

    public VeterinarianListDTO(Veterinarian veterinarian){
        this(
                veterinarian.getId(),
                veterinarian.getName(),
                veterinarian.getEmail(),
                veterinarian.getCrmv(),
                veterinarian.getSpecialization()
        );
    }
}
