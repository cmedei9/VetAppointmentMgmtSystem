package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Divisions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBDivisions {

    /**
     * method to return the list of divisions from the database
     * @return returns a list of the divisions in the database
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList<Divisions> getDivisions() throws SQLException {

        ObservableList<Divisions> divisionList = FXCollections.observableArrayList();
        String sql = "SELECT * from first_level_divisions";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {

            int divisionID = result.getInt("Division_ID");
            String divisionName = result.getString("Division");
            int countryID = result.getInt("Country_ID");

            Divisions d = new Divisions(divisionID, divisionName, countryID);
            divisionList.add(d);

        }
        return divisionList;
    }

    /**
     * method to return division by name
     *
     * @param d String division name
     * @return returns the division
     * @throws SQLException exception to show failed jdbc execution
     */
    public static Divisions getDivisionId(String d) throws SQLException {

        String sql = "SELECT * from first_level_divisions WHERE Division = ?";

        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);

        statement.setString(1, d);

        try {
            statement.execute();

            ResultSet rs = statement.getResultSet();

            while (rs.next()) {
                Divisions division = new Divisions(

                        rs.getInt("Division_ID"),
                        rs.getString("Division"),
                        rs.getInt("Country_ID"));

                return division;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    /**
     * Method to get all divisions in the US from the database
     *
     * @return returns a list of states in the US
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList<Divisions> getUsDivisions() throws SQLException {

        ObservableList<Divisions> divisionList = FXCollections.observableArrayList();
        String sql = "SELECT * from first_level_divisions WHERE Division_ID BETWEEN 1 AND 54";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {

            Divisions d = new Divisions(

                    result.getInt("Division_ID"),
                    result.getString("Division"),
                    result.getInt("Country_ID"));

            divisionList.add(d);

        }
        return divisionList;
    }

    /**
     * method to return the division names for the US divisions
     *
     * @return returns US division names
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList addDivisionNameUs() throws SQLException {
        ObservableList<String> divisionList = FXCollections.observableArrayList();

        ObservableList<Divisions> divisionsObservableList = getUsDivisions();

        for (Divisions d : divisionsObservableList) {
            divisionList.add(d.getDivisionName());
        }
        return divisionList;
    }

    /**
     * Method to get all divisions in  Canada from the database
     *
     * @return returns a list of states in Canada
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList<Divisions> getCanadaDivisions() throws SQLException {

        ObservableList<Divisions> divisionList = FXCollections.observableArrayList();
        String sql = "SELECT * from first_level_divisions WHERE Division_ID BETWEEN 60 AND 72";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {

            Divisions d = new Divisions(

                    result.getInt("Division_ID"),
                    result.getString("Division"),
                    result.getInt("Country_ID"));

            divisionList.add(d);

        }
        return divisionList;
    }

    /**
     * method to return the division names for the Canada divisions
     *
     * @return returns Canada division names
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList addDivisionNameCanada() throws SQLException {
        ObservableList<String> divisionList = FXCollections.observableArrayList();

        ObservableList<Divisions> divisionsObservableList = getCanadaDivisions();

        for (Divisions d : divisionsObservableList) {
            divisionList.add(d.getDivisionName());
        }
        return divisionList;
    }


    /**
     * Method to get all divisions in the UK from the database
     *
     * @return returns a list of states in the UK
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList<Divisions> getUkDivisions() throws SQLException {

        ObservableList<Divisions> divisionList = FXCollections.observableArrayList();
        String sql = "SELECT * from first_level_divisions WHERE Division_ID BETWEEN 101 AND 104";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {

            Divisions d = new Divisions(

                    result.getInt("Division_ID"),
                    result.getString("Division"),
                    result.getInt("Country_ID"));

            divisionList.add(d);

        }
        return divisionList;
    }

    /**
     * method to return the division names for the UK divisions
     *
     * @return returns UK division names
     * @throws SQLException exception to show failed jdbc execution
     */
    public static ObservableList addDivisionNameUk() throws SQLException {
        ObservableList<String> divisionList = FXCollections.observableArrayList();

        ObservableList<Divisions> divisionsObservableList = getUkDivisions();

        for (Divisions d : divisionsObservableList) {
            divisionList.add(d.getDivisionName());
        }
        return divisionList;
    }

}
