package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Divisions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBDivisions {

    public static ObservableList<Divisions> getDivisions() throws SQLException {

        ObservableList<Divisions> divisionList = FXCollections.observableArrayList();
        String sql = "SELECT * from first_level_divisions";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while(result.next()){

        int divisionID = result.getInt("Division_ID");
        String divisionName = result.getString("Division");
        int countryID = result.getInt("Country_ID");

        Divisions d = new Divisions(divisionID, divisionName, countryID);
        divisionList.add(d);

        }
        return divisionList;
    }

    public static Divisions getDivisionId(String d) throws SQLException {

        String sql = "SELECT * from first_level_divisions WHERE Division = ?";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);

        statement.setString(1, d);

        try {
            statement.execute();
            ResultSet rs = statement.getResultSet();

            while (rs.next()) {
                Divisions nd = new Divisions(

                        rs.getInt("Division_ID"),
                        rs.getString("Division"),
                        rs.getInt("Country_ID"));

                return nd;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public static ObservableList<Divisions> getUsDivisions() throws SQLException {

        ObservableList<Divisions> divisionList = FXCollections.observableArrayList();
        String sql = "SELECT * from first_level_divisions WHERE Division_ID BETWEEN 1 AND 54";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while(result.next()){

            Divisions d = new Divisions(

            result.getInt("Division_ID"),
            result.getString("Division"),
            result.getInt("Country_ID"));

            divisionList.add(d);

        }
        return divisionList;
    }

    public static ObservableList addDivisionNameUs() throws SQLException {
        ObservableList<String> divisionList = FXCollections.observableArrayList();

        ObservableList<Divisions> divisionsObservableList = getUsDivisions();

        for (Divisions d : divisionsObservableList) {
            divisionList.add(d.getDivisionName());
        }
        return divisionList;
    }

    public static ObservableList<Divisions> getCanadaDivisions() throws SQLException {

        ObservableList<Divisions> divisionList = FXCollections.observableArrayList();
        String sql = "SELECT * from first_level_divisions WHERE Division_ID BETWEEN 60 AND 72";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while(result.next()){

            Divisions d = new Divisions(

                    result.getInt("Division_ID"),
                    result.getString("Division"),
                    result.getInt("Country_ID"));

            divisionList.add(d);

        }
        return divisionList;
    }

    public static ObservableList addDivisionNameCanada() throws SQLException {
        ObservableList<String> divisionList = FXCollections.observableArrayList();

        ObservableList<Divisions> divisionsObservableList = getCanadaDivisions();

        for (Divisions d : divisionsObservableList) {
            divisionList.add(d.getDivisionName());
        }
        return divisionList;
    }



    public static ObservableList<Divisions> getUkDivisions() throws SQLException {

        ObservableList<Divisions> divisionList = FXCollections.observableArrayList();
        String sql = "SELECT * from first_level_divisions WHERE Division_ID BETWEEN 101 AND 104";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while(result.next()){

            Divisions d = new Divisions(

                    result.getInt("Division_ID"),
                    result.getString("Division"),
                    result.getInt("Country_ID"));

            divisionList.add(d);

        }
        return divisionList;
    }

    public static ObservableList addDivisionNameUk() throws SQLException {
        ObservableList<String> divisionList = FXCollections.observableArrayList();

        ObservableList<Divisions> divisionsObservableList = getUkDivisions();

        for (Divisions d : divisionsObservableList) {
            divisionList.add(d.getDivisionName());
        }
        return divisionList;
    }

/*    public static ObservableList<String> getCanadaDivisions() throws SQLException {

        ObservableList<String> divisionList = FXCollections.observableArrayList();
        String sql = "SELECT * from first_level_divisions WHERE Division_ID BETWEEN 60 AND 72";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while(result.next()){

            String divisionName = result.getString("Division");
            divisionList.add(divisionName);

        }
        return divisionList;
    }*/
/*

    public static ObservableList<String> getUkDivisions() throws SQLException {

        ObservableList<String> divisionList = FXCollections.observableArrayList();
        String sql = "SELECT * from first_level_divisions WHERE Division_ID BETWEEN 101 AND 104";
        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while(result.next()){

            String divisionName = result.getString("Division");
            divisionList.add(divisionName);

        }
        return divisionList;
    }

*/


        public static int divisionNameToId() throws SQLException {
        int divisionID = 0;

        ObservableList<Divisions> divisionsObservableList = getDivisions();
        for (Divisions d : divisionsObservableList) {
            if (divisionsObservableList.equals(d.getDivisionName()))
                divisionID = d.getDivisionID();

        }
        return divisionID;
    }

    public static ObservableList addDivisionName() throws SQLException {
        ObservableList<String> divisionList = FXCollections.observableArrayList();

        ObservableList<Divisions> divisionsObservableList = getDivisions();

        for (Divisions d : divisionsObservableList) {
            divisionList.add(d.getDivisionName());
        }
        return divisionList;
    }

    public static ObservableList addDivisionId() throws SQLException {
        ObservableList<Integer> divisionList = FXCollections.observableArrayList();

        ObservableList<Divisions> divisionsObservableList = DBDivisions.getDivisions();

        for (Divisions d : divisionsObservableList) {
            divisionList.add(d.getDivisionID());
        }
        return divisionList;
    }


}
