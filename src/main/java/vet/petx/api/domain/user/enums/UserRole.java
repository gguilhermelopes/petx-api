package vet.petx.api.domain.user.enums;

public enum UserRole {
    ADMIN(0),
    USER(1);
    private int code;
    private UserRole(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static vet.petx.api.domain.user.enums.UserRole valueOf(int code){
        for(UserRole value : UserRole.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Species code");
    }
}
