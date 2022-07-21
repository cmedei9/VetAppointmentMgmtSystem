package model;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointments {

    private int appointmentID;
    private String appointmentTitle;
    private String appointmentDescription;
    private String appointmentLocation;
    private String appointmentType;
    private LocalDate apptStartDate;
    private LocalDateTime apptStartTime;
    private LocalDate apptEndDate;
    private LocalDateTime apptEndTime;
    private int customerID;
    private int userID;
    private int contactID;
    private String contactName;




    /**
     *
     * @param appointmentID INT value appt ID
     * @param appointmentTitle String value appt title
     * @param appointmentDescription String value appt description
     * @param appointmentLocation String value appt location
     * @param appointmentType String value appt type
     * @param apptStartDate LocalDate value appts start date
     * @param apptStartTime LocalDateTime value appts start time
     * @param apptEndDate LocalDate value appts end date
     * @param apptEndTime LocalDateTime value appts end time
     * @param customerID INT value customer ID
     * @param userID INT value user ID
     * @param contactID INT value Contact ID
     * @param contactName string value contact name
     */
    public Appointments(int appointmentID, String appointmentTitle, String appointmentDescription,
                        String appointmentLocation, String appointmentType, LocalDate apptStartDate, LocalDateTime apptStartTime,
                        LocalDate apptEndDate, LocalDateTime apptEndTime, int customerID, int userID, int contactID, String contactName){

        this.appointmentID = appointmentID;
        this.appointmentTitle = appointmentTitle;
        this.appointmentDescription = appointmentDescription;
        this.appointmentLocation = appointmentLocation;
        this.appointmentType = appointmentType;
        this.apptStartTime = apptStartTime;
        this.apptEndTime = apptEndTime;
        this.customerID = customerID;
        this.userID = userID;
        this.contactID = contactID;
        this.contactName = contactName;
        this.apptStartDate = apptStartDate;
        this.apptEndDate = apptEndDate;

    }


    /**
     * return appt ID
     * @return appt ID
     */
    public int getAppointmentID() {
        return appointmentID;
    }

    /**
     * returns appt title
     * @return appt title
     */
    public String getAppointmentTitle(){
        return appointmentTitle;
    }

    /**
     * returns appt description
     * @return returns appt description
     */
    public String getAppointmentDescription(){
        return appointmentDescription;
    }

    /**
     * returns appt location
     * @return appt location
     */
    public String getAppointmentLocation() {
        return appointmentLocation;
    }

    /**
     * returns appt type
     * @return appt type
     */
    public String getAppointmentType(){
        return appointmentType;
    }

    /**
     * returns appt start time
     *
     * @return appt start time
     */
    public LocalDateTime getApptStartTime(){
        return apptStartTime;
    }

    /**
     * returns appt end time
     *
     * @return appt end time
     */
    public LocalDateTime getApptEndTime() {
        return apptEndTime;
    }

    /**
     * gets customer id
     * @return returns customer id
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * returns user id
     * @return user id
     */
    public int getUserID() {
        return userID;
    }

    /**
     * returns contact ID - unused
     * @return contact ID
     */
    public int getContactID() {
        return contactID;
    }

    /**
     * returns contact name
     * @return contact name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * returns appt start date
     * @return appt start date
     */
    public LocalDate getApptStartDate() {
        return apptStartDate;
    }

    /**
     * returns appt end date
     * @return appt end date
     */
    public LocalDate getApptEndDate() {
        return apptEndDate;
    }

}