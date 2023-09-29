package vet.petx.api.domain.user.DTO;

import vet.petx.api.domain.user.enums.UserRole;

public record RegisterDataDTO(String email, String password, UserRole role) {
}
