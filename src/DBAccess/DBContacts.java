package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contacts;
import model.Divisions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBContacts {

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

    public static ObservableList addContacts() throws SQLException {
        ObservableList<String> contactsList = FXCollections.observableArrayList(); //OL list of just contact names

        ObservableList<Contacts> contactsObservableList = getContacts(); //OL of all contacts

        for (Contacts c : contactsObservableList) {
            contactsList.add(c.getContactName());
        }

        return contactsList;
    }

    public static ObservableList addContactsId() throws SQLException {
        ObservableList<Integer> contactsList = FXCollections.observableArrayList();

        ObservableList<Contacts> contactsObservableList = getContacts();

        for (Contacts c : contactsObservableList) {
            contactsList.add(c.getContactID());
        }


        return contactsList;
    }

    public static int contactNametoID() throws SQLException {
        int contactId = 0;

        ObservableList<Contacts> contactsObservableList = DBContacts.getContacts();
        for (Contacts c : contactsObservableList) {
            if (contactsObservableList.equals(c.getContactName()))
                contactId = c.getContactID();

        }
        return contactId;
    }
}
