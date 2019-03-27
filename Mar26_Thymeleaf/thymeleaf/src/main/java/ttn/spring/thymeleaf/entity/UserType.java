package ttn.spring.thymeleaf.entity;

public enum UserType {
    USER("has user role"),
    ADMIN("has admin role"),
    SUPER_ADMIN("has super_admin role");

    String message;

    UserType(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
