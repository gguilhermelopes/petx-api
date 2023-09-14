package vet.petx.api.veterinarian;

import vet.petx.api.address.AddressData;
import vet.petx.api.veterinarian.enums.Specialization;

public record Veterinarian
        (String name, String email, String crmv, Specialization specialization, AddressData address) {
}
