package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Countries;

import java.sql.*;



public class DBCountries {

    /**
     * method that returns all countries
     * @return returns the country list
     * @throws SQLException exception to show failed jdbc execution
     */
   public static ObservableList<Countries> getCountries() throws SQLException{

        ObservableList<Countries> countryList = FXCollections.observableArrayList();
        String sql = "SELECT * from countries";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

            while(result.next()){
                int countryID = result.getInt("Country_ID");
                String countryName = result.getString("Country");

                Countries c = new Countries(countryID, countryName);
                countryList.add(c);
            }

        return countryList;
    }

    /**
     * method used in the customer controllers to add country names to the combo box
     * @return returns the country names
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList addCountryName() throws SQLException {
        ObservableList<String> countryList = FXCollections.observableArrayList();

        ObservableList<Countries> countriesObservableList = DBCountries.getCountries();

        for (Countries c : countriesObservableList) {
            countryList.add(c.getCountryName());
        }
        return countryList;
    }

}
