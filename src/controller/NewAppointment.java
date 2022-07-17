package controller;

import DBAccess.DBAppointments;
import DBAccess.DBContacts;
import DBAccess.DBCustomers;
import DBAccess.DBUsers;
import helper.Alerts;
import helper.Helper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Appointments;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class NewAppointment implements Initializable {
    public Button saveButton;
    public Button cancelButton;
    public ComboBox<String> startTimeComboBox;
    public ComboBox<String> endTimeComboBox;
    public TextField titleField;
    public DatePicker startCalendar;
    public TextField descField;
    public TextField locationField;
    public TextField typeField;
    public TextField appointmentIdField;
    public ComboBox<String> contactComboBox;
    public ComboBox<Integer> userIdComboBox;
    public ComboBox<Integer> customerIdComboBox;


    public boolean saveFlag = true;

    public void onSaveButton(ActionEvent actionEvent) throws IOException, SQLException {

        saveFlag = true;

        if (titleField.getText().isEmpty() || descField.getText().isEmpty() || locationField.getText().isEmpty() || typeField.getText().isEmpty() || startCalendar.getValue() == null || startTimeComboBox.getSelectionModel().isEmpty() || endTimeComboBox.getSelectionModel().isEmpty()
                || customerIdComboBox.getSelectionModel().isEmpty() || userIdComboBox.getSelectionModel().isEmpty() || contactComboBox.getSelectionModel().isEmpty()){

            Alerts.emptyFields();
            saveFlag = false;
            return;
        }


        ObservableList<Appointments> appointmentsObservableList = DBAppointments.customerIdToAppointment(customerIdComboBox.getSelectionModel().getSelectedItem());
        LocalTime timeSelectionStart = LocalTime.parse(startTimeComboBox.getSelectionModel().getSelectedItem());
        LocalTime timeSelectionEnd = LocalTime.parse(endTimeComboBox.getSelectionModel().getSelectedItem());
        LocalDateTime newApptStart = startCalendar.getValue().atTime(timeSelectionStart);
        LocalDateTime newApptEnd = startCalendar.getValue().atTime(timeSelectionEnd);

        for(Appointments a: appointmentsObservableList) {

            LocalDateTime previouslyScheduledStartDate = a.getApptStartDate().atTime(a.getApptStartTime().toLocalTime());
            LocalDateTime previouslyScheduledEndDate = a.getApptEndDate().atTime(a.getApptEndTime().toLocalTime());

            if (previouslyScheduledStartDate.equals(newApptStart.minusMinutes(1))){
                Alerts.appointmentConfliction();
                System.out.println("1");
                saveFlag = false;
                return;

            }

            else if (previouslyScheduledEndDate.equals(newApptEnd.minusMinutes(1))){
                Alerts.appointmentConfliction();
                System.out.println("2");
                saveFlag = false;
                return;

            }

            else if (previouslyScheduledStartDate.isAfter(newApptStart) && previouslyScheduledStartDate.isBefore(newApptEnd)) {
                Alerts.appointmentConfliction();
                saveFlag = false;
                return;
            }

            else if (previouslyScheduledEndDate.isAfter(newApptStart) && previouslyScheduledEndDate.isBefore(newApptEnd)) {
                Alerts.appointmentConfliction();
                saveFlag = false;
                return;
            }


        }

        LocalDate localDate = startCalendar.getValue(); // Value of appointment date
        LocalTime localTimeStart = LocalTime.parse(startTimeComboBox.getValue()); // Start time converter to users local time
        LocalTime localTimeEnd = LocalTime.parse(endTimeComboBox.getValue()); // End time converter to users local time

        LocalDateTime start = LocalDateTime.of(localDate, localTimeStart); // LocalDateTime of users start date and start time
        LocalDateTime end = LocalDateTime.of(localDate, localTimeEnd); // LocalDateTime of users end date and end time

        ZonedDateTime localToZoneStart = ZonedDateTime.of(start, ZoneId.systemDefault()); // ZoneDateTime of users zone
        ZonedDateTime localtoEstStart = localToZoneStart.withZoneSameInstant(ZoneId.of("America/New_York")); // ZoneDateTime (start) of users zone converted to EST
        ZonedDateTime localToZoneEnd = ZonedDateTime.of(end, ZoneId.systemDefault()); // ZoneDateTime of users zone
        ZonedDateTime localtoEstEnd = localToZoneEnd.withZoneSameInstant(ZoneId.of("America/New_York")); //ZoneDateTime (end) of users zone converted to EST

        LocalTime localTimeToEstStart = localtoEstStart.toLocalTime(); // Converts users time to EST time
        LocalTime localTimeToEstEnd = localtoEstEnd.toLocalTime(); // Converts users time to EST time

        if(LocalTime.parse(startTimeComboBox.getSelectionModel().getSelectedItem()).isAfter(LocalTime.parse(endTimeComboBox.getSelectionModel().getSelectedItem()))
                || LocalTime.parse(startTimeComboBox.getSelectionModel().getSelectedItem()).equals(LocalTime.parse(endTimeComboBox.getSelectionModel().getSelectedItem()))){

            Alerts.appointmentEndBeforeStart();
            saveFlag = false;
        }

        else if(localTimeToEstStart.isBefore(LocalTime.of(8,0)) || localTimeToEstStart.isAfter(LocalTime.of(22,0))
        || localTimeToEstEnd.isBefore(LocalTime.of(8,0)) || localTimeToEstEnd.isAfter(LocalTime.of(22,0))){
            Alerts.outsideBusinessHours();
            saveFlag = false;
        }




        else if(saveFlag = true) {
        DBAppointments.newAppointment(

                titleField.getText(),
                descField.getText(),
                locationField.getText(),
                typeField.getText(),
                LocalDateTime.of(startCalendar.getValue(), LocalTime.parse(startTimeComboBox.getSelectionModel().getSelectedItem())),
                LocalDateTime.of(startCalendar.getValue(), LocalTime.parse(endTimeComboBox.getSelectionModel().getSelectedItem())),
                customerIdComboBox.getSelectionModel().getSelectedItem(),
                userIdComboBox.getSelectionModel().getSelectedItem(),
                contactComboBox.getSelectionModel().getSelectedItem());


            // return home
            Parent root = FXMLLoader.load(Objects.requireNonNull(Helper.class.getResource("/view/MainScreen.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            }


    }


    public void onCancelButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            appointmentIdField.setText("Auto-Generated");
            contactComboBox.setItems(DBContacts.addContacts());
            customerIdComboBox.setItems(DBCustomers.addCustomerId());
            userIdComboBox.setItems(DBUsers.addUserId());
            startTimeComboBox.setItems(Helper.addBusinessHoursStart());
            endTimeComboBox.setItems(Helper.addBusinessHoursEnd());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}