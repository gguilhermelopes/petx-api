package vet.petx.api.domain.pet;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.petx.api.domain.pet.DTO.PetUpdateDTO;
import vet.petx.api.domain.pet.enums.Species;
import vet.petx.api.domain.petOwner.PetOwner;

@Table(name = "pets")
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

    public void updateInfo(PetUpdateDTO obj){
        if(obj.name() != null) this.name = obj.name();
        if(obj.species() != null) this.species = obj.species();
        if(obj.age() != null) this.age = obj.age();
        if(obj.breed() != null) this.breed = obj.breed();
        if(obj.weight() != null) this.weight = obj.weight();
    }

}


