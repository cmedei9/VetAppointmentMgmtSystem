package DBAccess;


import helper.JDBC;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import model.Customers;
import model.Divisions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCustomers {

    /**
     * method used to return all customer information in the database
     * @return returns the complete list of customers in the database
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList<Customers> getCustomers() throws SQLException {

        ObservableList<Customers> customerList = FXCollections.observableArrayList();
        String sql = "SELECT * from customers INNER JOIN first_level_divisions ON customers.Division_ID = first_level_divisions.Division_ID INNER JOIN countries c on first_level_divisions.Country_ID = c.Country_ID";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {

            int customerID = result.getInt("Customer_ID");
            String customerName = result.getString("Customer_Name");
            String customerAddress = result.getString("Address");
            String customerPostalCode = result.getString("Postal_Code");
            String customerPhoneNumber = result.getString("Phone");
            String divisionName = result.getString("Division");
            int divisionID = result.getInt("Division_ID");
            String country = result.getString("Country");

            Customers c = new Customers(customerID, customerPostalCode, divisionID, customerName, customerAddress, customerPhoneNumber, country, divisionName);
            customerList.add(c);
        }

        return customerList;
    }

    /**
     * method used for creation of a new customer in the database
     * @param customerName String customers name
     * @param customerAddress String customers address
     * @param customerPostalCode String customers postal code
     * @param customerPhoneNumber String customers phone number
     * @param division String division the customer belongs to
     * @return returns the customer information
     * @throws SQLException exception to show failed jdbc execution
     */
    public static boolean newCustomer(String customerName, String customerAddress,
                                      String customerPostalCode, String customerPhoneNumber, String division) throws SQLException {

        Divisions customerDivision = DBDivisions.getDivisionId(division);

        String sql = "INSERT INTO customers (Customer_Name,Address,Postal_Code,Phone,Division_ID) VALUES(?,?,?,?,?)";
        PreparedStatement statement = JDBC.connection.prepareStatement(sql);

        statement.setString(1, customerName);
        statement.setString(2, customerAddress);
        statement.setString(3, customerPostalCode);
        statement.setString(4, customerPhoneNumber);
        statement.setInt(5, customerDivision.getDivisionID());


        boolean add = statement.execute();

        return add;
    }

    /**
     *
     * method used for modifying an existing customer in the database
     * @param customerId Int for customer ID
     * @param customerName String customers name
     * @param customerAddress String customers address
     * @param customerPostalCode String customers postal code
     * @param customerPhoneNumber String customers phone number
     * @param division String division the customer belongs to
     * @return returns the customer information
     * @throws SQLException exception to show failed jdbc execution
     */
    public static int modifyCustomer(int customerId, String customerName, String customerAddress,
                                     String customerPostalCode, String customerPhoneNumber, String division) throws SQLException {

        Divisions customerDivision = DBDivisions.getDivisionId(division);

        String sql = "UPDATE customers set Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Division_ID = ? WHERE Customer_ID = ?";
        PreparedStatement statement = JDBC.connection.prepareStatement(sql);


        statement.setString(1, customerName);
        statement.setString(2, customerAddress);
        statement.setString(3, customerPostalCode);
        statement.setString(4, customerPhoneNumber);
        statement.setInt(5, customerDivision.getDivisionID());
        statement.setInt(6, customerId);

        int add = statement.executeUpdate();
        return add;
    }

    /**
     * Method used to remove a customer from the database
     * @param cid customers ID
     * @return returns true if the ID is found in the database
     * @throws SQLException exception to show failed jdbc execution
     */
    public static boolean removeCustomer(int cid) throws SQLException {

        String sql = "DELETE from customers WHERE Customer_ID = ?";

        PreparedStatement statement = JDBC.connection.prepareStatement(sql);
        statement.setInt(1,cid);

        statement.execute();

        return true;
    }

    /**
     * Method used to populate combo boxes with all customer ID's
     * @return returns a list of all customer ID's
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList addCustomerId() throws SQLException {
        ObservableList<Integer> customerList = FXCollections.observableArrayList();

        ObservableList<Customers> customersObservableList = DBCustomers.getCustomers();

        for (Customers c : customersObservableList) {
            customerList.add(c.getCustomerID());
        }


        return customerList;
    }

}

