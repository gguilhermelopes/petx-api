package vet.petx.api.veterinarian.enums;

public enum Specialization {
    CLINICA_GERAL(1),
    CIRURGIA(2),
    RADIOLOGIA(3),
    PATOLOGIA(4);

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
