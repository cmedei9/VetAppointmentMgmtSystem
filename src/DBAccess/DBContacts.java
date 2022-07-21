package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contacts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBContacts {

    /**
     * method used to return all the contacts in the database
     * @return observablelist of contacts
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList<Contacts> getContacts() throws SQLException {

        ObservableList<Contacts> contactList = FXCollections.observableArrayList();
        String sql = "SELECT * from contacts";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {

            int contactID = result.getInt("Contact_ID");
            String contactName = result.getString("Contact_Name");
            String contactEmail = result.getString("Email");

            Contacts c = new Contacts(contactID, contactName, contactEmail);
            contactList.add(c);

        }

        return contactList;

    }

    /**
     * method used to return contact id by the contact name
     * @param c the parameter used for the contact name
     * @return returns the contact info
     * @throws SQLException exception to show failed jdbc execution
     */
    public static Contacts getContactId(String c) throws SQLException {

        String sql = "SELECT * from contacts WHERE Contact_Name = ?";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);

        statement.setString(1, c);

        try {
            statement.execute();
            ResultSet rs = statement.getResultSet();

            while (rs.next()) {
                Contacts contacts = new Contacts(

                        rs.getInt("Contact_ID"),
                        rs.getString("Contact_Name"),
                        rs.getString("Email"));

                return contacts;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    /**
     * method used mainly for adding contacts into comboboxes for other scenes
     * @return contactname is returned
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList addContacts() throws SQLException {
        ObservableList<String> contactsList = FXCollections.observableArrayList(); //OL list of just contact names

        ObservableList<Contacts> contactsObservableList = getContacts(); //OL of all contacts

        for (Contacts c : contactsObservableList) {
            contactsList.add(c.getContactName());
        }

        return contactsList;
    }

}