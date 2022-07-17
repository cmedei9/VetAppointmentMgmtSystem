package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contacts;
import model.Users;

import java.sql.*;
import java.time.LocalDateTime;

import java.sql.ResultSet;


public class DBUsers {

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

    public static ObservableList addUsers() throws SQLException {
        ObservableList<String> usersList = FXCollections.observableArrayList();

        ObservableList<Users> usersObservableList = DBUsers.getAllUsers();

        for (Users u : usersObservableList) {
            usersList.add(u.getUsername());
        }

        return usersList;
    }

    public static ObservableList addUserId() throws SQLException {
        ObservableList<Integer> usersList = FXCollections.observableArrayList();

        ObservableList<Users> usersObservableList = DBUsers.getAllUsers();

        for (Users u : usersObservableList) {
            usersList.add(u.getUserId());
        }

        return usersList;
    }

    public static int userNametoID() throws SQLException {
        int contactId = 0;

        ObservableList<Users> usersObservableList = DBUsers.getAllUsers();
        for (Users u : usersObservableList) {
            if (usersObservableList.equals(u.getUsername()))
                contactId = u.getUserId();

        }
        return contactId;
    }

}
