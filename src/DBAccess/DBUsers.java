package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Users;

import java.sql.*;
import java.sql.ResultSet;


public class DBUsers {

    /**
     * method to return the list of users from the database
     * @return returns a list of the users in the database
     */
    public static ObservableList<Users> getAllUsers() {

        ObservableList<Users> userData = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * from Users";
            PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int userID = result.getInt("User_ID");
                String userName = result.getString("User_Name");
                String password = result.getString("Password");

                Users userList = new Users(userID, userName, password);
                userData.add(userList);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userData;
    }


    /**
     * method used in the multiple controllers to add user IDs to a combo box
     * @return returns the user IDs
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList addUserId() throws SQLException {
        ObservableList<Integer> usersList = FXCollections.observableArrayList();

        ObservableList<Users> usersObservableList = DBUsers.getAllUsers();

        for (Users u : usersObservableList) {
            usersList.add(u.getUserId());
        }

        return usersList;
    }
}
