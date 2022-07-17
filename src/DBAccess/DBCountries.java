package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Countries;
import model.Customers;

import java.sql.*;



public class DBCountries {

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

    public static ObservableList addCountryName() throws SQLException {
        ObservableList<String> countryList = FXCollections.observableArrayList();

        ObservableList<Countries> countriesObservableList = DBCountries.getCountries();

        for (Countries c : countriesObservableList) {
            countryList.add(c.getCountryName());
        }
        return countryList;
    }

    public static ObservableList addCountryId() throws SQLException {
        ObservableList<Integer> countryList = FXCollections.observableArrayList();

        ObservableList<Countries> countriesObservableList = DBCountries.getCountries();

        for (Countries c : countriesObservableList) {
            countryList.add(c.getCountryID());
        }


        return countryList;
    }



    public static void checkDateConversion(){
        System.out.println("CREATE DATE TEST");
        String sql = "select Create_Date from countries";

        try{
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Timestamp ts = rs.getTimestamp("Create_Date");
                System.out.println("CD: "+ts.toLocalDateTime().toString());
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
