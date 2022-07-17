package helper;

import DBAccess.DBAppointments;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.SQLException;
import java.util.Optional;



public class Alerts {



    public static void loginErrorAlertEn(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "User ID and/or password is incorrect.");
        alert.setTitle("Log in error");
        Optional<ButtonType> option = alert.showAndWait();
        }

    public static void loginErrorAlertFr(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Connexion identifiants et incorrect.");
        alert.setTitle("Log in error");
        Optional<ButtonType> option = alert.showAndWait();
        }

    public static void successfulDeletion(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Selected item was deleted successfully.");
        alert.setTitle("Success!");
        alert.setHeaderText("Success!");
        Optional<ButtonType> option = alert.showAndWait();
    }

    public static void deletionErrorNull(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to delete item. Please be sure a selection is made prior to clicking delete.");
        alert.setTitle("Deletion Failed");
        Optional<ButtonType> option = alert.showAndWait();
    }

    public static void customerContainsAppointmentError(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to delete item. Customer has appointment(s) scheduled. Please cancel the appointments prior to deleting the customer.");
        alert.setTitle("Deletion Failed");
        Optional<ButtonType> option = alert.showAndWait();
    }

    public static void successfulAppointmentDeletion() throws SQLException {

    }

    public static void appointmentEndBeforeStart(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to create/update appointment. Start time must be before end time.");
        alert.setTitle("Appointment Failure");
        Optional<ButtonType> option = alert.showAndWait();
    }

    public static void emptyFields(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please complete all fields before submitting.");
        alert.setTitle("Appointment Failure");
        Optional<ButtonType> option = alert.showAndWait();
    }

    public static void outsideBusinessHours(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please schedule an appointment between business hours (M-F, 8:00AM - 10:00PM Eastern Time.");
        alert.setTitle("Appointment Failure");
        Optional<ButtonType> option = alert.showAndWait();
    }

    public static void appointmentConfliction(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "The scheduled date/time for this customer's appointment conflicts with another scheduled appointment.");
        alert.setTitle("Appointment Failure");
        Optional<ButtonType> option = alert.showAndWait();
    }

    public static void appointmentNotification(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have an upcoming appointment scheduled within the next fifteen minutes.");
        alert.setTitle("Appointment Failure");
        Optional<ButtonType> option = alert.showAndWait();
    }

    public static void noAppointmentNotification(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "You do not have any appointments within the next fifteen minutes.");
        alert.setTitle("Appointment Failure");
        Optional<ButtonType> option = alert.showAndWait();
    }

    public static void noSelection(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please make a selection.");
        alert.setTitle("Error");
        Optional<ButtonType> option = alert.showAndWait();
    }

}



