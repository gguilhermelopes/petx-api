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

    public AddressData(AddressDataDTO address) {
        this.city = address.city();
        this.district = address.district();
        this.cep = address.cep();
        this.state = address.state();
        this.number = address.number();
        this.complement = address.complement();
    }
}
