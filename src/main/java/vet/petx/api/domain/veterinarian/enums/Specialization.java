package vet.petx.api.domain.veterinarian.enums;

public enum Specialization {
    CLINICA_GERAL(0),
    CIRURGIA(1),
    RADIOLOGIA(2),
    PATOLOGIA(3);

    private int code;
    private Specialization(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static Specialization valueOf(int code){
        for(Specialization value : Specialization.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Specialization code");
    }
}
