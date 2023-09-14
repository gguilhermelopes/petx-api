package vet.petx.api.address;

public record AddressDataDTO
        (String street, String district, String cep, String city, String state, String number, String complement) {
}
