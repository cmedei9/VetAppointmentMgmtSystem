package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.*;

public class Helper {


    /**
     * Observable list that creates a list of times from 8AM-945PM in increments of 15. Used to populate combo boxes.
     *
     * @return Returns a list of times for appointments
     */
    public static ObservableList<String> addBusinessHoursStart() {
        ObservableList<String> timesObservableList = FXCollections.observableArrayList();

        LocalTime openingHour = LocalTime.of(8, 0);
        LocalTime closingHour = LocalTime.of(21, 45);

        timesObservableList.add(openingHour.toString());

        while (openingHour.isBefore(closingHour)) {
            openingHour = openingHour.plusMinutes(15);
            timesObservableList.add(openingHour.toString());
        }

        return timesObservableList;
    }
    /**
     * Observable list that creates a list of times from 815AM-10PM in increments of 15. Used to populate combo boxes.
     *
     * @return Returns a list of times for appointments
     */
    public static ObservableList<String> addBusinessHoursEnd() {
        ObservableList<String> timesObservableList = FXCollections.observableArrayList();

        LocalTime openingHour = LocalTime.of(8, 15);
        LocalTime closingHour = LocalTime.of(22, 0);

        timesObservableList.add(openingHour.toString());

        while (openingHour.isBefore(closingHour)) {
            openingHour = openingHour.plusMinutes(15);
            timesObservableList.add(openingHour.toString());
        }

        return timesObservableList;
    }
}










