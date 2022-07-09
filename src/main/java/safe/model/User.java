package safe.model;

/**
 * This class represents a User object.
 */
public class User {
    protected String userName;
    protected String email;
    protected String password;

    /**
     * Constructs a User object with the following parameters.
     * @param userName - username for user
     * @param email - user's email address
     * @param password - user's password
     */
    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    /** Getters and Setters */
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
