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
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String crmv;
    @Enumerated(EnumType.ORDINAL)
    private Specialization specialization;
    @Embedded
    private AddressData address;
}
