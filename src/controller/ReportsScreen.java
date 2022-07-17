package controller;

import DBAccess.DBAppointments;

import DBAccess.DBContacts;
import DBAccess.DBCustomers;
import helper.Alerts;
import helper.Helper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Appointments;
import model.Contacts;
import model.Customers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ReportsScreen implements Initializable {


    public ComboBox appointmentTypeComboBox;
    public Button generateTypeButton;
    public ComboBox monthComboBox;
    public Button generateMonthButton;
    public ComboBox<Integer> contactComboBox;
    public Button generateContactReportButton;

    public ObservableList<String> appointmentType = FXCollections.observableArrayList();
    public ObservableList<String> appointmentTypeDupes = FXCollections.observableArrayList();
    public ObservableList<String> months = FXCollections.observableArrayList();
    public ObservableList<Integer> appointmentDate = FXCollections.observableArrayList();
    public ObservableList<Integer> contactId = FXCollections.observableArrayList();
    public ObservableList<Integer> customerId = FXCollections.observableArrayList();

    public Button totalCustomerButton;
    public Button backButton;


    /**
     * Method to get all types from the database. There are 2 observablelists. One contains duplicate entries and the other removes duplicates.
     * @throws SQLException
     */
    public void typeDataBox() throws SQLException {
        ObservableList<Appointments> a = DBAppointments.getAppointments();

        for (Appointments appointments : a) {
            if (!appointmentType.contains(appointments.getAppointmentType())) {
                appointmentType.add(appointments.getAppointmentType());
            }
        }
        for (Appointments appointments : a) {
                appointmentTypeDupes.add(appointments.getAppointmentType());
        }
    }



    /**
     * This method gathers the total number of appointments that contain the same type string
      * @param actionEvent method is ran on button press
     * @throws SQLException
     */
    public void onGenerateTypeButton(ActionEvent actionEvent) throws SQLException {

        Object selection = appointmentTypeComboBox.getSelectionModel().getSelectedItem();


        if(selection == null){
            Alerts.noSelection();
        }

        else if(appointmentTypeDupes.contains(selection)){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There are " + Collections.frequency(appointmentTypeDupes, selection) + " appointments scheduled of type: " + selection);
            alert.setTitle("Appointment Type Schedule");
            alert.setHeaderText("Appointment Type Schedule");
            Optional<ButtonType> option = alert.showAndWait();

            System.out.println(Collections.frequency(appointmentTypeDupes, selection));
        }

    }

    /**
     * Method to get all appointments and convert the date into the months value
     * @throws SQLException
     */
    public void monthDataBox() throws SQLException {
        ObservableList<Appointments> a = DBAppointments.getAppointments();


        for (Appointments appointments : a) {
            LocalDate apptDate = appointments.getApptStartDate();
            appointmentDate.add(apptDate.getMonthValue());

        }
    }

    /**
     * Method to count the total number of appointments scheduled in a selected month
     * @param actionEvent on button press, method runs
     * @throws SQLException
     */
    public void onGenerateMonthButton(ActionEvent actionEvent) throws SQLException {

        Object selection = monthComboBox.getSelectionModel().getSelectedItem();

        if(selection == null){
            Alerts.noSelection();
        }

        else if(selection == String.valueOf(Month.JANUARY)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments");
            alert.setHeaderText("Appointments");
            alert.setContentText("There are " + Collections.frequency(appointmentDate,  1) + " appointments scheduled in the month of " + selection);
            alert.showAndWait();

        }

        else if(selection == String.valueOf(Month.FEBRUARY)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments");
            alert.setHeaderText("Appointments");
            alert.setContentText("There are " + Collections.frequency(appointmentDate,  2) + " appointments scheduled in the month of " + selection);
            alert.showAndWait();

        }

        else if(selection == String.valueOf(Month.MARCH)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments");
            alert.setHeaderText("Appointments");
            alert.setContentText("There are " + Collections.frequency(appointmentDate,  3) + " appointments scheduled in the month of " + selection);
            alert.showAndWait();

        }

        else if(selection == String.valueOf(Month.APRIL)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments");
            alert.setHeaderText("Appointments");
            alert.setContentText("There are " + Collections.frequency(appointmentDate,  4) + " appointments scheduled in the month of " + selection);
            alert.showAndWait();

        }

        else if(selection == String.valueOf(Month.MAY)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments");
            alert.setHeaderText("Appointments");
            alert.setContentText("There are " + Collections.frequency(appointmentDate,  5) + " appointments scheduled in the month of " + selection);
            alert.showAndWait();

        }

        else if(selection == String.valueOf(Month.JUNE)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments");
            alert.setHeaderText("Appointments");
            alert.setContentText("There are " + Collections.frequency(appointmentDate,  6) + " appointments scheduled in the month of " + selection);
            alert.showAndWait();

        }

        else if(selection == String.valueOf(Month.JULY)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments");
            alert.setHeaderText("Appointments");
            alert.setContentText("There are " + Collections.frequency(appointmentDate,  7) + " appointments scheduled in the month of " + selection);
            alert.showAndWait();

        }

        else if(selection == String.valueOf(Month.AUGUST)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments");
            alert.setHeaderText("Appointments");
            alert.setContentText("There are " + Collections.frequency(appointmentDate,  8) + " appointments scheduled in the month of " + selection);
            alert.showAndWait();

        }

        else if(selection == String.valueOf(Month.SEPTEMBER)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments");
            alert.setHeaderText("Appointments");
            alert.setContentText("There are " + Collections.frequency(appointmentDate,  9) + " appointments scheduled in the month of " + selection);
            alert.showAndWait();

        }

        else if(selection == String.valueOf(Month.OCTOBER)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments");
            alert.setHeaderText("Appointments");
            alert.setContentText("There are " + Collections.frequency(appointmentDate,  10) + " appointments scheduled in the month of " + selection);
            alert.showAndWait();

        }

        else if(selection == String.valueOf(Month.NOVEMBER)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments");
            alert.setHeaderText("Appointments");
            alert.setContentText("There are " + Collections.frequency(appointmentDate,  11) + " appointments scheduled in the month of " + selection);
            alert.showAndWait();

        }

        else if(selection == String.valueOf(Month.DECEMBER)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments");
            alert.setHeaderText("Appointments");
            alert.setContentText("There are " + Collections.frequency(appointmentDate,  12) + " appointments scheduled in the month of " + selection);
            alert.showAndWait();

        }

    }

    /**
     * Populates the months of the years into the combobox
     */
    public void addMonths(){
        months.add(String.valueOf(Month.JANUARY));
        months.add(String.valueOf(Month.FEBRUARY));
        months.add(String.valueOf(Month.MARCH));
        months.add(String.valueOf(Month.APRIL));
        months.add(String.valueOf(Month.MAY));
        months.add(String.valueOf(Month.JUNE));
        months.add(String.valueOf(Month.JULY));
        months.add(String.valueOf(Month.AUGUST));
        months.add(String.valueOf(Month.SEPTEMBER));
        months.add(String.valueOf(Month.OCTOBER));
        months.add(String.valueOf(Month.NOVEMBER));
        months.add(String.valueOf(Month.DECEMBER));

    }

    /**
     * method to fill the contacts observable list which is used to populate the contact id combo box
     * @throws SQLException
     */
    public void contactDataBox() throws SQLException {
        ObservableList<Contacts> dbContacts = DBContacts.getContacts();

        for(Contacts c : dbContacts){
            if (!contactId.contains(c.getContactID())){
                contactId.add(c.getContactID());
            }
        }
    }


    /**
     * button to initialize the report generation method. creates an alert that displays a contacts appointment information. if there are multiple appointments, multiple alerts will display.
     * @param actionEvent action event
     */
    public void onGenerateContactReportButton(ActionEvent actionEvent) throws SQLException {

        if(contactComboBox.getSelectionModel().getSelectedItem() == null){
            Alerts.noSelection();
            return;
        }

        int selection = contactComboBox.getSelectionModel().getSelectedItem();

        ObservableList<Appointments> appointmentsObservableList = DBAppointments.contactIdToAppointment(selection);


        for(Appointments a : appointmentsObservableList){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments for Contact ID " + selection);
            alert.setHeaderText("Appointments for Contact ID " + selection);
            alert.setContentText(

                    "Contact Name: " + a.getContactName()+"\n"+
                    "Appointment ID: " + a.getAppointmentID()+"\n"+
                    "Title: " + a.getAppointmentTitle()+"\n"+
                    "Type: " + a.getAppointmentType()+"\n"+
                    "Description: " + a.getAppointmentDescription()+"\n"+
                    "Start Time: " + a.getApptStartDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")) + " " + a.getApptStartTime().format(DateTimeFormatter.ofPattern("HH:mm"))+"\n"+
                    "End Time: " + a.getApptEndDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")) + " " + a.getApptEndTime().format(DateTimeFormatter.ofPattern("HH:mm"))+"\n"+
                    "Customer ID: " + a.getAppointmentType()+"\n"

            );

            alert.showAndWait();

        }
    }

    /**
     * Total Customer button will grab all the customers in the database and will provide a total of customers
     * @param actionEvent action event
     */
    public void onTotalCustomerButton(ActionEvent actionEvent) throws SQLException {
        ObservableList<Customers> customersObservableList = DBCustomers.getCustomers();

        for(Customers c : customersObservableList){
            customerId.add(c.getCustomerID());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Total Number of Customers");
            alert.setHeaderText("Total Number of Customers");
            alert.setContentText("There are currently " + customersObservableList.size() + " customers in the database.");
            alert.showAndWait();

            return;
        }

    }

    /**
     * Back button to take user back to the home controller
     * @param actionEvent
     * @throws IOException
     */
    public void onBackButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    /**
     * initialize used to run methods upon scene change
     * @param url url
     * @param resourceBundle resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            typeDataBox();
            addMonths();
            monthDataBox();
            contactDataBox();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        contactComboBox.setItems(contactId);
        appointmentTypeComboBox.setItems(appointmentType);
        monthComboBox.setItems(months);
    }





}

