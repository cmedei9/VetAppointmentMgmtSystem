package controller;

import DBAccess.DBAppointments;
import DBAccess.DBCustomers;
import helper.Alerts;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointments;
import model.Customers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;


public class MainScreen implements Initializable {
    public Button newAppointmentButton;
    public Button modifyAppointmentButton;
    public Button deleteAppointmentButton;
    public Button newCustomerButton;
    public Button modifyCustomerButton;
    public Button deleteCustomerButton;
    public Button logoutButton;
    public TableView<Appointments> appointmentTableView;
    public TableColumn apptIdCol;
    public TableColumn apptTitleCol;
    public TableColumn apptDescriptionCol;
    public TableColumn apptLocationCol;
    public TableColumn apptContactCol;
    public TableColumn apptStartTimeCol;
    public TableColumn apptEndTimeCol;
    public TableColumn apptCustomerIdCol;
    public TableColumn apptUserIdCol;
    public TableColumn apptTypeCol;
    public TableView<Customers> customerTableView;
    public TableColumn custIdCol;
    public TableColumn custCustNameCol;
    public TableColumn custAddressCol;
    public TableColumn custPostalCodeCol;
    public TableColumn custTelephoneCol;
    public TableColumn custDivisionCol;
    public TableColumn custCountryCol;
    public RadioButton monthFilter;
    public RadioButton weekFilter;
    public RadioButton allAppointmentsFilter;
    public Label appointmentLabel;
    public ToggleGroup filterButtonGroup;
    public Button reportsButton;
    public Label systemTimeLabel;
    public Label eastCoastTimeLabel;

    public static boolean firstRun = true;

    private ObservableList<Appointments> appointmentsObservableList;
    private ObservableList<Customers> customersObservableList;


    /**
     * method to get the customers from the database and add them to the tableview
     * @throws SQLException exception to show failed jdbc execution
     */
    public void addCustomerTableData() throws SQLException{
        ObservableList<Customers> customersTableList = DBCustomers.getCustomers();
        customerTableView.setItems(customersTableList);
    }

    /**
     * method to get the appointments from the database and add them to the tableview
     * @throws SQLException exception to show failed jdbc execution
     */
    public void addAppointmentTableData() throws SQLException{
        ObservableList<Appointments> appointmentsObservableList = DBAppointments.getAppointments();
        appointmentTableView.setItems(appointmentsObservableList);
    }

    /**
     * interface for string systemTime
     */
    interface systemTime{
        String systemTime();
    }

    /**
     * interface for string eastCoastTime
     */
    interface eastCoastTime{
        String eastCoastTime();
    }
    /**
     * lambda expression - used to populate system time (local time)
     */
    void setSystemTimeLabel(){
        systemTime t = () -> LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        systemTimeLabel.setText(t.systemTime());
    }

    /**
     * lambda expression - used to populate east coast time
     */
    void setEstTimeLabel(){
        eastCoastTime est = () -> LocalDateTime.now(ZoneId.of("America/New_York")).format(DateTimeFormatter.ofPattern("HH:mm"));
        eastCoastTimeLabel.setText(est.eastCoastTime());

    }

    /**
     * scene switcher - loads the new customer scene
     * @param actionEvent actionevent - on click
     * @throws IOException exception to show failed IO execution
     */
    public void onNewCustomerButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/NewCustomer.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method is used to get the selected customer in the tableview, and use the selection to populate the fields in the
     * modify customer scene. If no customer is selected, an alert is displayed.
     * @param actionEvent actionevent on click
     * @throws IOException exception to show failed IO execution
     */
    public void onModifyCustomerButton(ActionEvent actionEvent) throws IOException {

        if((customerTableView.getSelectionModel().getSelectedItem()) == null){
            Alerts.noSelection();
        }

        else {
            ModifyCustomer.selectedCustomer(customerTableView.getSelectionModel().getSelectedItem());


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/ModifyCustomer.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    /**
     * Method is used to get the selected appointment in the tableview, and use the selection to populate the fields in the
     * modify appointment scene. If no appointment is selected, an alert is displayed.
     * @param actionEvent actionevent on click
     * @throws IOException exception to show failed IO execution
     */
    public void onModifyAppointmentButton(ActionEvent actionEvent) throws IOException {

        if((appointmentTableView.getSelectionModel().getSelectedItem()) == null){
            Alerts.noSelection();
        }

        else {
            ModifyAppointment.selectedItem(appointmentTableView.getSelectionModel().getSelectedItem());

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/ModifyAppointment.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    /**
     * Method is used to verify customer does not currently have any appointments.
     * @param customer Passed to verify if customer currently contains an appointment
     * @return returns int value, must be equal to 1 or greater
     * @throws SQLException exception to show failed jdbc execution
     */
    public boolean customerScheduledAppointments(Customers customer) throws SQLException {
        ObservableList a = DBAppointments.customerIdToAppointment(customer.getCustomerID());
        return a.size() >= 1;
    }

    /**
     * Method is used to delete a customer upon selection. Will display an alert if no selection is made on the tableview.
     * Will display confirmation message if deletion was successful. If a customer contains an appointment, an alert will display
     * notifying the user and will not delete.
     * @param actionEvent actionevent - on click
     * @throws SQLException exception to show failed jdbc execution
     */
    public void onDeleteCustomerButton(ActionEvent actionEvent) throws SQLException {

        Customers customerToDelete = customerTableView.getSelectionModel().getSelectedItem();

        if (customerToDelete == null) {
            Alerts.deletionErrorNull();
        }
        else if(customerScheduledAppointments(customerToDelete) == true){
            Alerts.customerContainsAppointmentError();
        }
        else {
            DBCustomers.removeCustomer(customerToDelete.getCustomerID());
            customersObservableList = DBCustomers.getCustomers();
            customerTableView.setItems(customersObservableList);
            customerTableView.refresh();

            Alerts.successfulDeletion();
        }
    }

    /**
     * Method to delete the selected appointment in the tableview and DB. If no appointment is selected, an alert will display.
     * If successful, a notification will display to let the user know.
     * @param actionEvent actionevent - on click
     * @throws SQLException exception to show failed jdbc execution
     */
    public void onDeleteAppointmentButton(ActionEvent actionEvent) throws  SQLException {

        Appointments appointmentToDelete = appointmentTableView.getSelectionModel().getSelectedItem();

        if(appointmentToDelete == null){
            Alerts.deletionErrorNull();
        }

        else if(appointmentToDelete != null) {
            DBAppointments.removeAppointment(appointmentToDelete.getAppointmentID());
            appointmentsObservableList = DBAppointments.getAppointments();
            appointmentTableView.setItems(appointmentsObservableList);
            appointmentTableView.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Appointment ID: " + appointmentToDelete.getAppointmentID() + " has been deleted. Appointment type was: " + appointmentToDelete.getAppointmentType());
            alert.setTitle("Success!");
            alert.setHeaderText("Success!");
            Optional<ButtonType> option = alert.showAndWait();

        }
    }

    /**
     * scene switcher - loads the new appointment scene
     * @param actionEvent actionevent - on click
     * @throws IOException exception to show failed IO execution
     */
    public void onNewAppointmentButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/NewAppointment.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * scene switcher - redirects back to login page scene
     * @param actionEvent actionevent - on click
     * @throws IOException exception to show failed IO execution
     */
    public void onLogoutButton(ActionEvent actionEvent) throws IOException {
        firstRun = true;

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/LoginScreen.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * scene switcher - loads the reports scene
     * @param actionEvent actionevent - on click
     * @throws IOException exception to show failed IO execution
     */
    public void onReportsButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/ReportsScreen.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Method to filter the appointments table view to show the monthly appointments. Will also change the label to reflect
     * the current view
     * @param actionEvent actionevent - on click
     * @throws SQLException exception to show failed jdbc execution
     */
    public void onMonthFilterButton(ActionEvent actionEvent) throws SQLException {
        appointmentsObservableList = DBAppointments.getMonthlyAppointments();
        appointmentTableView.setItems(appointmentsObservableList);
        appointmentTableView.refresh();

        appointmentLabel.setText("Monthly Appointments");

    }

    /**
     * Method to filter the appointments table view to show the weekly appointments. Will also change the label to reflect
     * the current view
     * @param actionEvent actionevent - on click
     * @throws SQLException exception to show failed jdbc execution
     */
    public void onWeekFilterButton(ActionEvent actionEvent) throws SQLException {
        appointmentsObservableList = DBAppointments.getWeeklyAppointments();
        appointmentTableView.setItems(appointmentsObservableList);
        appointmentTableView.refresh();

        appointmentLabel.setText("Weekly Appointments");

    }

    /**
     * Method to filter the appointments table view to show all appointments. Will also change the label to reflect
     * the current view
     * @param actionEvent actionevent - on click
     * @throws SQLException exception to show failed jdbc execution
     */
    public void onAllFilterButton(ActionEvent actionEvent) throws SQLException {
        appointmentsObservableList = DBAppointments.getAppointments();
        appointmentTableView.setItems(appointmentsObservableList);
        appointmentTableView.refresh();

        appointmentLabel.setText("Appointment List");

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        custIdCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        custCustNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        custAddressCol.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        custPostalCodeCol.setCellValueFactory(new PropertyValueFactory<>("customerPostalCode"));
        custTelephoneCol.setCellValueFactory(new PropertyValueFactory<>("customerPhoneNumber"));
        custCountryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        custDivisionCol.setCellValueFactory(new PropertyValueFactory<>("divisionName"));


        apptIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        apptTitleCol.setCellValueFactory(new PropertyValueFactory<>("appointmentTitle"));
        apptDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("appointmentDescription"));
        apptLocationCol.setCellValueFactory(new PropertyValueFactory<>("appointmentLocation"));
        apptTypeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
        apptStartTimeCol.setCellValueFactory(new PropertyValueFactory<>("apptStartTime"));
        apptEndTimeCol.setCellValueFactory(new PropertyValueFactory<>("apptEndTime"));
        apptCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        apptUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userID"));
        apptContactCol.setCellValueFactory(new PropertyValueFactory<>("contactID"));

        apptIdCol.setSortType(TableColumn.SortType.ASCENDING);
        custIdCol.setSortType(TableColumn.SortType.ASCENDING);

        weekFilter.setToggleGroup(filterButtonGroup);
        monthFilter.setToggleGroup(filterButtonGroup);
        allAppointmentsFilter.setToggleGroup(filterButtonGroup);
        allAppointmentsFilter.setSelected(true);
        filterButtonGroup.getSelectedToggle();

        setEstTimeLabel();
        setSystemTimeLabel();



        try {
            addCustomerTableData();
            addAppointmentTableData();
            appointmentTableView.getSortOrder().add(apptIdCol);
            customerTableView.getSortOrder().add(custIdCol);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



}
