package controller;

import DBAccess.DBAppointments;
import helper.Alerts;
import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Appointments;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable {
    public TextField userIDField;
    public TextField passwordField;
    public Button loginButton;
    public Button exitButton;
    public Label locationLabel;
    public Label passwordLabel;
    public Label userIdLabel;
    public Label titleLabel;

    boolean login = false;

    /**
     * upcomingAppointment method pulls all appointments from the database and adds all appointments within fifteen minutes of login
     * to the 'futureAppointments' observablelist. Alerts are generated both for an upcoming appointment or no appointment.
     * @throws SQLException exception to show failed jdbc execution
     */
    public static void upcomingAppointment() throws SQLException {


        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fifteenAfter = LocalDateTime.now().plusMinutes(15);

        ObservableList<Appointments> futureAppointments = FXCollections.observableArrayList();
        ObservableList<Appointments> appointmentsObservableList = DBAppointments.getAppointments();

        for (Appointments a : appointmentsObservableList){

            if(a.getApptStartTime().isAfter(now) && a.getApptStartTime().isBefore(fifteenAfter)){
                futureAppointments.add(a);
            }
        }

        if(futureAppointments.size() >= 1){
            Alerts.appointmentNotification();
        }

        else {
            Alerts.noAppointmentNotification();
        }
    }

    /**
     * Login button changes the scene to the main screen after a successful user login
     * @param actionEvent actionevent
     * @throws IOException exception to prevent I/O failure
     * @throws SQLException exception to show failed jdbc execution
     */
    public void onLoginButton(ActionEvent actionEvent) throws IOException, SQLException {

        String credentials = "SELECT * FROM users WHERE User_Name = '" + userIDField.getText() + "' AND Password = '" + passwordField.getText() + "'";

        Statement statement = JDBC.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(credentials);

        if(rs.next()){

            login = true;
            logger();

            try {
                upcomingAppointment();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

        else if (Locale.getDefault().getLanguage().equals("fr")){
            login = false;
            logger();
            Alerts.loginErrorAlertFr();

        }
        else if (Locale.getDefault().getLanguage().equals("en")){
            login = false;
            logger();
            Alerts.loginErrorAlertEn();



        }
    }

    /**
     * Password field replicates the same action as the login button
     * @param actionEvent actionevent
     * @throws IOException exception to prevent I/O failure
     * @throws SQLException exception to show failed jdbc execution
     */
    public void onPasswordField(ActionEvent actionEvent) throws IOException, SQLException {

        String loginQuery = "SELECT * FROM users WHERE User_Name = '" + userIDField.getText() + "' AND Password = '" + passwordField.getText() + "'";

        Statement statement = JDBC.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(loginQuery);

        if(rs.next()){

            login = true;
            logger();

            try {
                upcomingAppointment();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

        else if (Locale.getDefault().getLanguage().equals("fr")){
            login = false;
            logger();
            Alerts.loginErrorAlertFr();

        }
        else if (Locale.getDefault().getLanguage().equals("en")){
            login = false;
            logger();
            Alerts.loginErrorAlertEn();
        }
    }

    /**
     * logger method to track successful and failed log in attempts. records if successful/failed, user id used, password used, and a timestamp. file is saved in the
     * root directory as login_activity.txt
     * @throws IOException exception to prevent I/O failure
     */
    public void logger() throws IOException {
        String userID = userIDField.getText();
        String password = passwordField.getText();
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        FileWriter fw = new FileWriter("login_activity.txt", true);

        if(login) {

            fw.write("LOGIN ATTEMPT - SUCCESS\n" + "User ID Entered: " + userID + " | Password entered: " + password +
                    " | Timestamp: " + timestamp + "\n");
            System.out.println("Logging successful log-on attempt...");

        }

        else{

            fw.write("LOGIN ATTEMPT - FAIL\n" + "User ID Entered: " + userID + " | Password entered: " + password +
                    " | Timestamp: " + timestamp + "\n");
            System.out.println("Logging failed log-on attempt...");

        }

        fw.close();

    }

    /**
     * location interface for lambda expression
     */
    interface location{
        String systemLocation();
    }

    /**
     * lambda expression for part B, sets the label on the login screen to the zoneId of the user
     */
    void locationLabel(){
        location msg = () -> String.valueOf(ZoneId.of(String.valueOf(ZoneId.systemDefault())));
        locationLabel.setText(msg.systemLocation());
    }


    /**
     *  Exits the applications
     * @param actionEvent System.exit closes the application
     * @throws IOException exception to show failed IO execution
     */
    public void onExit(ActionEvent actionEvent) throws IOException {
        System.exit(0);
    }


    /**
     * initialize function to set text and to get the Locale of the user
     * @param url url
     * @param resourceBundle resourcebundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        locationLabel();

        resourceBundle = ResourceBundle.getBundle("controller/Nat", Locale.getDefault());
        if(Locale.getDefault().getLanguage().equals("fr") || Locale.getDefault().getLanguage().equals("en")) {

            titleLabel.setText(resourceBundle.getString("title"));
            userIdLabel.setText(resourceBundle.getString("user"));
            passwordLabel.setText(resourceBundle.getString("password"));
            exitButton.setText(resourceBundle.getString("exit"));
            loginButton.setText(resourceBundle.getString("login"));
            passwordLabel.setText(resourceBundle.getString("password"));
        }
    }
}
