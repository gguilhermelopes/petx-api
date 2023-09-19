package vet.petx.api.veterinarian;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.petx.api.address.AddressData;
import vet.petx.api.veterinarian.enums.Specialization;

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

    public Veterinarian(VeterinarianDTO obj) {
        this.name = obj.name();
        this.email = obj.email();
        this.phone = obj.phone();
        this.crmv = obj.crmv();
        this.specialization = obj.specialization();
        this.address = new AddressData(obj.address());
    }
}
