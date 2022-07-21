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
     * getter for user id
     * @return user id
     */
    public int getUserId() {
        return userId;
    }


    /**
     * getter for username - unused
     * @return returns username
     */
    public String getUsername() {
        return username;
    }

    /**
     * getter for password - unused
     * @return returns password
     */
    public String getPassword() {
        return password;
    }
}
