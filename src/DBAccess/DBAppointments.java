package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;
import model.Contacts;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public class DBAppointments {

    public static LocalDateTime now = LocalDateTime.now();
    public static LocalDateTime week = LocalDateTime.now().plus(7, ChronoUnit.DAYS);
    public static LocalDateTime month = LocalDateTime.now().plus(1, ChronoUnit.MONTHS);


    public static ObservableList<Appointments> getAppointments() throws SQLException {

        ObservableList<Appointments> appointmentList = FXCollections.observableArrayList();
        String sql = "SELECT * from appointments INNER JOIN contacts ON appointments.Contact_ID = contacts.Contact_ID";

        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();


        while (result.next()) {

            int appointmentID = result.getInt("Appointment_ID");
            String appointmentTitle = result.getString("Title");
            String appointmentDescription = result.getString("Description");
            String appointmentLocation = result.getString("Location");
            String appointmentType = result.getString("Type");
            LocalDate apptStartDate = result.getDate("Start").toLocalDate();
            LocalDateTime apptStartTime = result.getTimestamp("Start").toLocalDateTime();
            LocalDate apptEndDate = result.getDate("End").toLocalDate();
            LocalDateTime apptEndTime = result.getTimestamp("End").toLocalDateTime();
            int customerID = result.getInt("Customer_ID");
            int userID = result.getInt("User_ID");
            int contactID = result.getInt("Contact_ID");
            String contactName = result.getString("Contact_Name");


            Appointments a = new Appointments(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, apptStartDate,
                    apptStartTime, apptEndDate, apptEndTime, customerID, userID, contactID, contactName);
            appointmentList.add(a);
        }

        return appointmentList;
    }

    public static ObservableList<LocalDateTime> getStartAppointments() throws SQLException {

        ObservableList<LocalDateTime> appointmentList = FXCollections.observableArrayList();
        String sql = "SELECT Start from appointments INNER JOIN contacts ON appointments.Contact_ID = contacts.Contact_ID";

        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();


        while (result.next()) {


            LocalDate apptStartDate = result.getDate("Start").toLocalDate();
            LocalDateTime apptStartTime = result.getTimestamp("Start").toLocalDateTime();

            LocalDateTime startDateTime = apptStartDate.atTime(LocalTime.from(apptStartTime));


            appointmentList.add(startDateTime);
        }

        return appointmentList;
    }


    public static ObservableList<Appointments> getWeeklyAppointments() throws SQLException {

        ObservableList<Appointments> appointmentList = FXCollections.observableArrayList();
        String sql = "SELECT * from appointments INNER JOIN contacts ON appointments.Contact_ID = contacts.Contact_ID WHERE Start > ? && Start < ?";

        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);

        statement.setDate(1, Date.valueOf(now.toLocalDate()));
        statement.setDate(2, Date.valueOf(week.toLocalDate()));

        ResultSet result = statement.executeQuery();



        while (result.next()) {

            int appointmentID = result.getInt("Appointment_ID");
            String appointmentTitle = result.getString("Title");
            String appointmentDescription = result.getString("Description");
            String appointmentLocation = result.getString("Location");
            String appointmentType = result.getString("Type");
            LocalDate apptStartDate = result.getDate("Start").toLocalDate();
            LocalDateTime apptStartTime = result.getTimestamp("Start").toLocalDateTime();
            LocalDate apptEndDate = result.getDate("End").toLocalDate();
            LocalDateTime apptEndTime = result.getTimestamp("End").toLocalDateTime();
            int customerID = result.getInt("Customer_ID");
            int userID = result.getInt("User_ID");
            int contactID = result.getInt("Contact_ID");
            String contactName = result.getString("Contact_Name");


            Appointments a = new Appointments(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, apptStartDate,
                    apptStartTime, apptEndDate, apptEndTime, customerID, userID, contactID, contactName);
            appointmentList.add(a);
        }

        return appointmentList;
    }

    public static ObservableList<Appointments> getMonthlyAppointments() throws SQLException {

        ObservableList<Appointments> appointmentList = FXCollections.observableArrayList();

        String sql = "SELECT * from appointments INNER JOIN contacts ON appointments.Contact_ID = contacts.Contact_ID WHERE Start > ? && Start < ?";

        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);

        statement.setDate(1, Date.valueOf(now.toLocalDate()));
        statement.setDate(2, Date.valueOf(month.toLocalDate()));

        ResultSet result = statement.executeQuery();



        while (result.next()) {

            int appointmentID = result.getInt("Appointment_ID");
            String appointmentTitle = result.getString("Title");
            String appointmentDescription = result.getString("Description");
            String appointmentLocation = result.getString("Location");
            String appointmentType = result.getString("Type");
            LocalDate apptStartDate = result.getDate("Start").toLocalDate();
            LocalDateTime apptStartTime = result.getTimestamp("Start").toLocalDateTime();
            LocalDate apptEndDate = result.getDate("End").toLocalDate();
            LocalDateTime apptEndTime = result.getTimestamp("End").toLocalDateTime();
            int customerID = result.getInt("Customer_ID");
            int userID = result.getInt("User_ID");
            int contactID = result.getInt("Contact_ID");
            String contactName = result.getString("Contact_Name");


            Appointments a = new Appointments(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, apptStartDate,
                    apptStartTime, apptEndDate, apptEndTime, customerID, userID, contactID, contactName);
            appointmentList.add(a);
        }

        return appointmentList;


    }

    public static ObservableList<Appointments> getAppointmentsType(String type) throws SQLException {

        ObservableList<Appointments> appointmentList = FXCollections.observableArrayList();

        String sql = "SELECT * from appointments WHERE Type = ?";

        PreparedStatement statement = JDBC.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        statement.setString(1, type);

        while (result.next()) {

            int appointmentID = result.getInt("Appointment_ID");
            String appointmentTitle = result.getString("Title");
            String appointmentDescription = result.getString("Description");
            String appointmentLocation = result.getString("Location");
            String appointmentType = result.getString("Type");
            LocalDate apptStartDate = result.getDate("Start").toLocalDate();
            LocalDateTime apptStartTime = result.getTimestamp("Start").toLocalDateTime();
            LocalDate apptEndDate = result.getDate("End").toLocalDate();
            LocalDateTime apptEndTime = result.getTimestamp("End").toLocalDateTime();
            int customerID = result.getInt("Customer_ID");
            int userID = result.getInt("User_ID");
            int contactID = result.getInt("Contact_ID");
            String contactName = result.getString("Contact_Name");


            Appointments a = new Appointments(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, apptStartDate,
                    apptStartTime, apptEndDate, apptEndTime, customerID, userID, contactID, contactName);
            appointmentList.add(a);
        }

        return appointmentList;


    }


    public static int newAppointment(String appointmentTitle, String appointmentDescription,
                                     String appointmentLocation, String appointmentType, LocalDateTime apptStartTime,
                                     LocalDateTime apptEndTime, int customerID, int userID, String contact) throws SQLException {

        Contacts c = DBContacts.getContactId(contact);

        String sql = "INSERT INTO appointments (Title,Description,Location,Type,Start,End,Customer_ID,User_ID,Contact_ID) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = JDBC.connection.prepareStatement(sql);

        statement.setString(1, appointmentTitle);
        statement.setString(2, appointmentDescription);
        statement.setString(3, appointmentLocation);
        statement.setString(4, appointmentType);
        statement.setTimestamp(5, Timestamp.valueOf(apptStartTime));
        statement.setTimestamp(6, Timestamp.valueOf(apptEndTime));
        statement.setInt(7, customerID);
        statement.setInt(8, userID);
        statement.setInt(9, c.getContactID());

        int add = statement.executeUpdate();
        return add;
    }

    public static int modifyAppointment(int appointmentId, String appointmentTitle, String appointmentDescription,
                                     String appointmentLocation, String appointmentType, LocalDateTime apptStartTime,
                                     LocalDateTime apptEndTime, int customerID, int userID, String contact) throws SQLException {

        Contacts c = DBContacts.getContactId(contact);

        String sql = "UPDATE appointments set Title = ?, Description = ?, Location = ?, Type = ?, Start = ?, End = ?, Customer_ID = ?, Contact_ID = ?, User_ID = ? WHERE Appointment_ID = ?";
        PreparedStatement statement = JDBC.connection.prepareStatement(sql);


        statement.setString(1, appointmentTitle);
        statement.setString(2, appointmentDescription);
        statement.setString(3, appointmentLocation);
        statement.setString(4, appointmentType);
        statement.setTimestamp(5, Timestamp.valueOf(apptStartTime));
        statement.setTimestamp(6, Timestamp.valueOf(apptEndTime));
        statement.setInt(7, customerID);
        statement.setInt(8, c.getContactID());
        statement.setInt(9, userID);
        statement.setInt(10, appointmentId);

        int add = statement.executeUpdate();
        return add;
    }


    public static boolean removeAppointment(int id) throws SQLException {

        String sql = "DELETE from appointments WHERE Appointment_ID = ?";

        PreparedStatement statement = JDBC.connection.prepareStatement(sql);
        statement.setInt(1,id);

        statement.execute();

        return true;
    }

    public static ObservableList<Appointments> contactIdToAppointment(int contact) throws SQLException {

        String sql = "SELECT * FROM appointments INNER JOIN contacts ON appointments.Contact_ID = contacts.Contact_ID WHERE appointments.Contact_ID = ?";
        PreparedStatement statement = JDBC.connection.prepareStatement(sql);

        ObservableList<Appointments> appointmentsObservableList = FXCollections.observableArrayList();

        statement.setInt(1, contact);

        statement.execute();
        ResultSet result = statement.getResultSet();

        while(result.next()){

            Appointments rs = new Appointments(

            result.getInt("Appointment_ID"),
            result.getString("Title"),
            result.getString("Description"),
            result.getString("Location"),
            result.getString("Type"),
            result.getDate("Start").toLocalDate(),
            result.getTimestamp("Start").toLocalDateTime(),
            result.getDate("Start").toLocalDate(),
            result.getTimestamp("End").toLocalDateTime(),
            result.getInt("Customer_ID"),
            result.getInt("User_ID"),
            result.getInt("Contact_ID"),
            result.getString("Contact_Name"));

            appointmentsObservableList.add(rs);
        }
        return appointmentsObservableList;
    }

    public static Appointments appointmentIdToAppointment(int appointmentId) throws SQLException {

        String sql = "SELECT * FROM appointments INNER JOIN contacts ON appointments.Contact_ID = contacts.Contact_ID WHERE Appointment_ID = ?";
        PreparedStatement statement = JDBC.connection.prepareStatement(sql);

        ObservableList<Appointments> appointmentsObservableList = FXCollections.observableArrayList();


        statement.setInt(1, appointmentId);

        statement.execute();
        ResultSet result = statement.getResultSet();

        while(result.next()){

        Appointments rs = new Appointments(

                result.getInt("Appointment_ID"),
                result.getString("Title"),
                result.getString("Description"),
                result.getString("Location"),
                result.getString("Type"),
                result.getDate("Start").toLocalDate(),
                result.getTimestamp("Start").toLocalDateTime(),
                result.getDate("Start").toLocalDate(),
                result.getTimestamp("End").toLocalDateTime(),
                result.getInt("Customer_ID"),
                result.getInt("User_ID"),
                result.getInt("Contact_ID"),
                result.getString("Contact_Name"));

        return rs;

        }

        return null;

    }

    public static ObservableList<Appointments> customerIdToAppointment(int customerId) throws SQLException {

        String sql = "SELECT * FROM appointments INNER JOIN contacts on appointments.Contact_ID = contacts.Contact_ID WHERE appointments.Customer_ID = ?";
        PreparedStatement statement = JDBC.connection.prepareStatement(sql);

        ObservableList<Appointments> appointmentsObservableList = FXCollections.observableArrayList();
        statement.setInt(1, customerId);

        statement.execute();
        ResultSet result = statement.getResultSet();

        while(result.next()){

            Appointments rs = new Appointments(

                    result.getInt("Appointment_ID"),
                    result.getString("Title"),
                    result.getString("Description"),
                    result.getString("Location"),
                    result.getString("Type"),
                    result.getDate("Start").toLocalDate(),
                    result.getTimestamp("Start").toLocalDateTime(),
                    result.getDate("Start").toLocalDate(),
                    result.getTimestamp("End").toLocalDateTime(),
                    result.getInt("Customer_ID"),
                    result.getInt("User_ID"),
                    result.getInt("Contact_ID"),
                    result.getString("Contact_Name"));

            appointmentsObservableList.add(rs);

        }
        return appointmentsObservableList;
    }










}


