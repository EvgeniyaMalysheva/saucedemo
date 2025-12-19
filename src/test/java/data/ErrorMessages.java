package data;

public enum ErrorMessages {
    INVALID_PASSWORD("Username and password do not match any user in this service"),
    USER_IS_LOCKED("Sorry, this user has been locked out."),
    USER_NAME_IS_EMPTY("Username is required");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
