package helper;

import DBAccess.DBAppointments;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.SQLException;
import java.util.Optional;



public class Alerts {


    /**
     * Alert that is used to display a login error (english) if credentials are incorrect
     */
    public static void loginErrorAlertEn(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "User ID and/or password is incorrect.");
        alert.setTitle("Log in error");
        Optional<ButtonType> option = alert.showAndWait();
        }

    /**
     * Alert that is used to display a login error (french) if credentials are incorrect
     */
    public static void loginErrorAlertFr(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Connexion identifiants et incorrect.");
        alert.setTitle("Log in error");
        Optional<ButtonType> option = alert.showAndWait();
        }

    /**
     * Alert that is used to inform the user a customer/appointment was deleted successfully
     */
    public static void successfulDeletion(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Selected item was deleted successfully.");
        alert.setTitle("Success!");
        alert.setHeaderText("Success!");
        Optional<ButtonType> option = alert.showAndWait();
    }

    /**
     * Alert that occurs when pressing the delete item before making a selection
     */
    public static void deletionErrorNull(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to delete item. Please be sure a selection is made prior to clicking delete.");
        alert.setTitle("Deletion Failed");
        Optional<ButtonType> option = alert.showAndWait();
    }

    /**
     * Alert that is used to notify a user that a customer has an appointment and cannot be deleted
     */
    public static void customerContainsAppointmentError(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to delete item. Customer has appointment(s) scheduled. Please cancel the appointments prior to deleting the customer.");
        alert.setTitle("Deletion Failed");
        Optional<ButtonType> option = alert.showAndWait();
    }



    /**
     * Alert that is used when scheduling to let the user know the appointment end time is before the start time
     */
    public static void appointmentEndBeforeStart(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to create/update appointment. Start time must be before end time.");
        alert.setTitle("Appointment Failure");
        Optional<ButtonType> option = alert.showAndWait();
    }

    /**
     * Alert that is displayed when the user does not enter all required fields
     */
    public static void emptyFields(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please complete all fields before submitting.");
        alert.setTitle("Appointment Failure");
        Optional<ButtonType> option = alert.showAndWait();
    }

    /**
     * Alert that is used to let the user know the time selected is outside business hours
     */
    public static void outsideBusinessHours(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please schedule an appointment between business hours (M-F, 8:00AM - 10:00PM Eastern Time.");
        alert.setTitle("Appointment Failure");
        Optional<ButtonType> option = alert.showAndWait();
    }

    /**
     * Alert that is used to let the user know that the appointment they are trying to create/modify conflicts with an already existing appointment
     */
    public static void appointmentConfliction(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "The scheduled date/time for this customer's appointment conflicts with another scheduled appointment.");
        alert.setTitle("Appointment Failure");
        Optional<ButtonType> option = alert.showAndWait();
    }

    /**
     * Alert that is used to notify a user upon login that there is an appointment due within the next fifteen minute
     */
    public static void appointmentNotification(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have an upcoming appointment scheduled within the next fifteen minutes.");
        alert.setTitle("Appointment Failure");
        Optional<ButtonType> option = alert.showAndWait();
    }

    /**
     * Alert that is used to let the user know upon login that there are no appointments due within 15 minutes
     */
    public static void noAppointmentNotification(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "You do not have any appointments within the next fifteen minutes.");
        alert.setTitle("Appointment Failure");
        Optional<ButtonType> option = alert.showAndWait();
    }

    /**
     * Alert that is used in the reports controller if no selection was made
     */
    public static void noSelection(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please make a selection.");
        alert.setTitle("Error");
        Optional<ButtonType> option = alert.showAndWait();
    }

}



