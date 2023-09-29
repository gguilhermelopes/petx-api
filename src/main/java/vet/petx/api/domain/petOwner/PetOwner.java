package vet.petx.api.domain.petOwner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.petx.api.domain.address.AddressData;
import vet.petx.api.domain.pet.Pet;
import vet.petx.api.domain.petOwner.DTO.PetOwnerInsertDTO;
import vet.petx.api.domain.petOwner.DTO.PetOwnerUpdateDTO;

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
    private AddressData address;
    @JsonIgnore
    @OneToMany(mappedBy = "petOwner")
    private List<Pet> pets = new ArrayList<>();
    private Boolean active;

    public PetOwner(PetOwnerInsertDTO obj){
        this.name = obj.name();
        this.cpf = obj.cpf();
        this.email = obj.email();
        this.address = new AddressData(obj.address());
        this.active = true;
    }

    public void updateInfo(PetOwnerUpdateDTO obj){
        if(obj.name() != null) this.name = obj.name();
        if(obj.email() != null) this.email = obj.email();
        if(obj.address() != null) this.address.updateInfo(obj.address());
        if(obj.cpf() != null) this.cpf = obj.cpf();
        if(obj.active() != null) this.active = obj.active();

    }

    public void inactivateVet() {
        this.active = false;
    }
}
