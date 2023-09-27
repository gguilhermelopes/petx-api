package vet.petx.api.domain.pet.enums;

public enum Species {
    CACHORRO(0),
    GATO(1)
;
    private int code;
    private Species(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static vet.petx.api.domain.pet.enums.Species valueOf(int code){
        for(vet.petx.api.domain.pet.enums.Species value : vet.petx.api.domain.pet.enums.Species.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Species code");
    }
}