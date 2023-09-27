package vet.petx.api.domain.address;

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
        this.street = address.street();
        this.city = address.city();
        this.district = address.district();
        this.cep = address.cep();
        this.state = address.state();
        this.number = address.number();
        this.complement = address.complement();
    }

    public void updateInfo(AddressDataDTO obj) {
        if(obj.street() != null) this.street = obj.street();
        if (obj.city() != null) this.city = obj.city();
        if (obj.district() != null) this.district = obj.district();
        if (obj.cep() != null) this.cep = obj.cep();
        if (obj.state() != null) this.state = obj.state();
        if (obj.number() != null) this.number = obj.number();
        if (obj.complement() != null) this.complement = obj.complement();
    }
}
