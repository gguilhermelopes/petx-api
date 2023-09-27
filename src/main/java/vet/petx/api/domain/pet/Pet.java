package vet.petx.api.domain.pet;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.petx.api.domain.pet.enums.Species;
import vet.petx.api.domain.petOwner.PetOwner;

@Table(name = "pet")
@Entity(name = "Pets")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private Species species;
    private Integer age;
    private String breed;
    private Long weight;
    @ManyToOne
    @JoinColumn(name = "pet_owner_id")
    private PetOwner petOwner;
}
