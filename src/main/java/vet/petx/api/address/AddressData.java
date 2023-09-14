package vet.petx.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressData {
    private String street;
    private String district;
    private String cep;
    private String city;
    private String state;
    private String number;
    private String complement;
}
