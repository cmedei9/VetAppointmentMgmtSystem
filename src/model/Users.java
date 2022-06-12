package model;

public class Users {

    private int userId;
    private String username;
    private String password;

    /**
     *
     * @param userId INT value user ID
     * @param username STRING value user name
     * @param password STRING value password
     */
    public Users(int userId, String username, String password){
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    /**
     * sets user id
     * @param userId setter for user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * getter for user id
     * @return user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * setter for username
     * @param username sets username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getter for username
     * @return returns username
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter for password
     * @param password sets password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter for password
     * @return returns password
     */
    public String getPassword() {
        return password;
    }
}
