package vet.petx.api.domain.veterinarian;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.petx.api.domain.address.AddressData;
import vet.petx.api.domain.veterinarian.enums.Specialization;

@Table(name = "veterinarians")
@Entity(name = "veterinarian")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Veterinarian {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crmv;
    @Enumerated(EnumType.ORDINAL)
    private Specialization specialization;
    @Embedded
    private AddressData address;
    private Boolean active;

    public Veterinarian(VeterinarianDTOInsert obj) {
        this.name = obj.name();
        this.email = obj.email();
        this.phone = obj.phone();
        this.crmv = obj.crmv();
        this.specialization = obj.specialization();
        this.address = new AddressData(obj.address());
        this.active = true;
    }

    public void updateInfo(VeterinarianDTOUpdate obj) {
        if(obj.name() != null) this.name = obj.name();
        if(obj.phone() != null) this.phone = obj.phone();
        if(obj.address() != null) this.address.updateInfo(obj.address());

    }

    public void inactivateVet() {
        this.active = false;
    }
}
