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
     * sets appt ID
     * @param appointmentID sets appt id
     */
    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    /**
     * returns appt title
     * @return appt title
     */
    public String getAppointmentTitle(){
        return appointmentTitle;
    }

    /**
     * sets appt title
     * @param appointmentTitle sets appt title
     */
    public void setAppointmentTitle(String appointmentTitle) {
        this.appointmentTitle = appointmentTitle;
    }

    /**
     * returns appt description
     * @return returns appt description
     */
    public String getAppointmentDescription(){
        return appointmentDescription;
    }

    /**
     * sets appt description
     * @param appointmentDescription sets appt description
     */
    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    /**
     * returns appt location
     * @return appt location
     */
    public String getAppointmentLocation() {
        return appointmentLocation;
    }

    /**
     * sets appt location
     * @param appointmentLocation sets appt location
     */
    public void setAppointmentLocation(String appointmentLocation) {
        this.appointmentLocation = appointmentLocation;
    }

    /**
     * returns appt type
     * @return appt type
     */
    public String getAppointmentType(){
        return appointmentType;
    }

    /**
     * sets appt type
     * @param appointmentType sets appt type
     */
    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
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
     * sets appt start time
     * @param apptStartTime sets appt start time
     */
    public void setApptStartTime(LocalDateTime apptStartTime){
        this.apptStartTime = apptStartTime;
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
     * sets appt end time
     * @param apptEndTime sets appt end time
     */
    public void setApptEndTime(LocalDateTime apptEndTime) {
        this.apptEndTime = apptEndTime;
    }

    /**
     * gets customer id
     * @return returns customer id
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * sets customer id
     * @param customerID sets customer id
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * returns user id
     * @return user id
     */
    public int getUserID() {
        return userID;
    }

    /**
     * sets user id
     * @param userID sets user id
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * returns contact ID
     * @return contact ID
     */
    public int getContactID() {
        return contactID;
    }

    /**
     * sets contact ID
     * @param contactID sets contact ID
     */
    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public LocalDate getApptStartDate() {
        return apptStartDate;
    }

    public void setApptStartDate(LocalDate apptStartDate) {
        this.apptStartDate = apptStartDate;
    }

    public LocalDate getApptEndDate() {
        return apptEndDate;
    }

    public void setApptEndDate(LocalDate apptEndDate) {
        this.apptEndDate = apptEndDate;
    }
}