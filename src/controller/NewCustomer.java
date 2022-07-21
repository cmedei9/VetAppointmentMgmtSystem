package controller;

import DBAccess.DBAppointments;
import DBAccess.DBCountries;
import DBAccess.DBCustomers;
import DBAccess.DBDivisions;
import helper.Helper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Countries;
import model.Divisions;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.ResourceBundle;

public class NewCustomer implements Initializable {
    public Button saveButton;
    public Button cancelButton;
    public TextField nameField;
    public TextField addressField;
    public TextField customerIdField;
    public TextField postalCodeField;
    public TextField phoneNumberField;
    public ComboBox<String> countryComboBox;
    public ComboBox<String> divisionComboBox;

    /**
     * Method to populate the division combobox. Will take the country selected and will filter the division based on selection.
     * @param actionEvent actionevent on click
     * @throws SQLException exception to show failed jdbc execution
     */
    public void onCountryComboBox(ActionEvent actionEvent) throws SQLException{

        if(countryComboBox.getSelectionModel().getSelectedItem().equals("U.S")){
            divisionComboBox.setItems(DBDivisions.addDivisionNameUs());
        }

        else if (countryComboBox.getSelectionModel().getSelectedItem().equals("Canada")){
            divisionComboBox.setItems(DBDivisions.addDivisionNameCanada());
        }

        else if (countryComboBox.getSelectionModel().getSelectedItem().equals("UK")){
            divisionComboBox.setItems(DBDivisions.addDivisionNameUk());
        }

    }

    /**
     * Save button to save the new customer in the DB. Takes user back to main controller.
     * @param actionEvent actionevent on click
     * @throws IOException exception to show failed IO execution
     * @throws SQLException exception to show failed jdbc execution
     */
    public void onSaveButton(ActionEvent actionEvent) throws IOException, SQLException {
        DBCustomers.newCustomer(

                nameField.getText(),
                addressField.getText(),
                postalCodeField.getText(),
                phoneNumberField.getText(),
                divisionComboBox.getValue());


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Takes user back to main controller.
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            countryComboBox.setItems(DBCountries.addCountryName());
            customerIdField.setText("Auto-Generated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
