package vet.petx.api.veterinarian;

import vet.petx.api.address.AddressDataDTO;
import vet.petx.api.veterinarian.enums.Specialization;

public record VeterinarianDTO
        (String name, String email, String crmv, Specialization specialization, AddressDataDTO address) {
}
