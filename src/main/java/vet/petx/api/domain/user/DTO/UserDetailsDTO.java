package vet.petx.api.domain.user.DTO;

import vet.petx.api.domain.user.enums.UserRole;



public record UserDetailsDTO (String email, String name, UserRole role){
}
