package controller;

import DBAccess.*;
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
import model.Appointments;
import model.Customers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class ModifyCustomer implements Initializable {
    public Button saveButton;
    public Button cancelButton;
    public TextField nameField;
    public TextField addressField;
    public TextField customerIdField;
    public TextField postalCodeField;
    public TextField phoneNumberField;
    public ComboBox<String> countryComboBox;
    public ComboBox<String> divisionComboBox;
    public static Customers selectedCustomer;

    public static void selectedCustomer(Customers selectedItem) {
        selectedCustomer = selectedItem;
    }

    public void onSaveButton(ActionEvent actionEvent) throws IOException, SQLException {


        DBCustomers.modifyCustomer(

                Integer.parseInt(customerIdField.getText()),
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

    public void onCancelButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public void onCountryComboBox(ActionEvent actionEvent) throws SQLException {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            countryComboBox.setItems(DBCountries.addCountryName());

            nameField.setText(selectedCustomer.getCustomerName());
            addressField.setText(selectedCustomer.getCustomerAddress());
            postalCodeField.setText(selectedCustomer.getCustomerPostalCode());
            phoneNumberField.setText(selectedCustomer.getCustomerPhoneNumber());
            customerIdField.setText(String.valueOf(selectedCustomer.getCustomerID()));
            countryComboBox.getSelectionModel().select(selectedCustomer.getCountry());
            divisionComboBox.getSelectionModel().select(selectedCustomer.getDivisionName());

            if(countryComboBox.getSelectionModel().getSelectedItem().equals("U.S")){
                divisionComboBox.setItems(DBDivisions.addDivisionNameUs());
            }

            else if (countryComboBox.getSelectionModel().getSelectedItem().equals("Canada")){
                divisionComboBox.setItems(DBDivisions.addDivisionNameCanada());
            }

            else if (countryComboBox.getSelectionModel().getSelectedItem().equals("UK")){
                divisionComboBox.setItems(DBDivisions.addDivisionNameUk());
            }


           } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
