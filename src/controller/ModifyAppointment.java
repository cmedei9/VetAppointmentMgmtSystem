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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Appointments;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class ModifyAppointment implements Initializable {
    public Button saveButton;
    public Button cancelButton;
    public ComboBox<String> endTimeComboBox;
    public ComboBox<String> startTimeComboBox;
    public ComboBox<String> contactComboBox;
    public TextField appointmentIdField;
    public TextField titleField;
    public DatePicker startCalendar;
    public TextField descField;
    public TextField locationField;
    public TextField typeField;
    public ComboBox<Integer> customerIdComboBox;
    public ComboBox<Integer> userIdComboBox;
    public static Appointments selectedItem;

    public boolean saveFlag = true;




    /**
     * Cancel button to take the user back to the main screen
     * @param actionEvent actionevent on click
     * @throws IOException exception to show failed IO execution
     */
    public void onCancelButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();



    }

    /**
     * Method to pass info from the selection on the main screen
     * @param appointment the appointment that was selected
     */
    public static void selectedItem(Appointments appointment){
        selectedItem = appointment;
    }

    /**
     * Save button which saves the information in the fields, comboboxes, and calendar data and save it to the database. Generates alerts for empty fields, customer appointment conflictions,
     * timing mismatches and for appointments within business hours. Also takes into consideration the users localtime and converts it to EST.
     * @param actionEvent actionevent on click
     * @throws IOException exception to show failed IO execution
     * @throws SQLException exception to show failed jdbc execution
     */
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
                saveFlag = false;
                return;

            }

            else if (previouslyScheduledEndDate.equals(newApptEnd.minusMinutes(1))){
                Alerts.appointmentConfliction();
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

        LocalDate localDate = startCalendar.getValue();
        LocalTime localTimeStart = LocalTime.parse(startTimeComboBox.getValue());
        LocalTime localTimeEnd = LocalTime.parse(endTimeComboBox.getValue());

        LocalDateTime start = LocalDateTime.of(localDate, localTimeStart);
        LocalDateTime end = LocalDateTime.of(localDate, localTimeEnd);

        ZonedDateTime localToZoneStart = ZonedDateTime.of(start, ZoneId.systemDefault());
        ZonedDateTime localtoEstStart = localToZoneStart.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime localToZoneEnd = ZonedDateTime.of(end, ZoneId.systemDefault());
        ZonedDateTime localtoEstEnd = localToZoneEnd.withZoneSameInstant(ZoneId.of("America/New_York"));

        LocalTime localTimeToEstStart = localtoEstStart.toLocalTime();
        LocalTime localTimeToEstEnd = localtoEstEnd.toLocalTime();

        if(LocalTime.parse(startTimeComboBox.getSelectionModel().getSelectedItem()).isAfter(LocalTime.parse(endTimeComboBox.getSelectionModel().getSelectedItem()))
                || LocalTime.parse(startTimeComboBox.getSelectionModel().getSelectedItem()).equals(LocalTime.parse(endTimeComboBox.getSelectionModel().getSelectedItem()))){

            Alerts.appointmentEndBeforeStart();
            saveFlag = false;
            return;
        }

        else if(localTimeToEstStart.isBefore(LocalTime.of(8,0)) || localTimeToEstStart.isAfter(LocalTime.of(22,0))
                || localTimeToEstEnd.isBefore(LocalTime.of(8,0)) || localTimeToEstEnd.isAfter(LocalTime.of(22,0))){
            Alerts.outsideBusinessHours();
            saveFlag = false;
            return;
        }


        else if(saveFlag = true) {
            DBAppointments.modifyAppointment(

                    Integer.parseInt(appointmentIdField.getText()),
                    titleField.getText(),
                    descField.getText(),
                    locationField.getText(),
                    typeField.getText(),
                    LocalDateTime.of(startCalendar.getValue(), LocalTime.parse(startTimeComboBox.getSelectionModel().getSelectedItem())),
                    LocalDateTime.of(startCalendar.getValue(), LocalTime.parse(endTimeComboBox.getSelectionModel().getSelectedItem())),
                    customerIdComboBox.getSelectionModel().getSelectedItem(),
                    userIdComboBox.getSelectionModel().getSelectedItem(),
                    contactComboBox.getSelectionModel().getSelectedItem());


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startTimeComboBox.setItems(Helper.addBusinessHoursStart());
        endTimeComboBox.setItems(Helper.addBusinessHoursEnd());





        try {

            contactComboBox.setItems(DBContacts.addContacts());
            customerIdComboBox.setItems(DBCustomers.addCustomerId());
            userIdComboBox.setItems(DBUsers.addUserId());

            Appointments a = DBAppointments.appointmentIdToAppointment(selectedItem.getAppointmentID());

            appointmentIdField.setText(String.valueOf(Integer.valueOf(selectedItem.getAppointmentID())));
            titleField.setText(selectedItem.getAppointmentTitle());
            descField.setText(selectedItem.getAppointmentDescription());
            locationField.setText(selectedItem.getAppointmentLocation());
            typeField.setText(selectedItem.getAppointmentType());

            contactComboBox.getSelectionModel().select(a.getContactName());
            userIdComboBox.getSelectionModel().select(Integer.valueOf(selectedItem.getUserID()));
            customerIdComboBox.getSelectionModel().select(Integer.valueOf(selectedItem.getCustomerID()));

            startCalendar.setValue(selectedItem.getApptStartTime().toLocalDate());

            startTimeComboBox.getSelectionModel().select(selectedItem.getApptStartTime().format(DateTimeFormatter.ofPattern("HH:mm")));
            endTimeComboBox.getSelectionModel().select(selectedItem.getApptEndTime().format(DateTimeFormatter.ofPattern("HH:mm")));






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
