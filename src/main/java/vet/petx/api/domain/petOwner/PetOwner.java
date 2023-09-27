package vet.petx.api.domain.petOwner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.petx.api.domain.address.AddressData;
import vet.petx.api.domain.pet.Pet;

import java.util.ArrayList;
import java.util.List;

@Table(name = "pet_owners")
@Entity(name = "Pet Owner")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class PetOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    @Embedded
    private AddressData addressData;
    @JsonIgnore
    @OneToMany(mappedBy = "petOwner")
    private List<Pet> pets = new ArrayList<>();

    private Boolean active;
}
