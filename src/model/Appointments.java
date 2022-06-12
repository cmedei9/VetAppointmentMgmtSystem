package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointments {

    private int appointmentId;
    private String appointmentTitle;
    private String appointmentDescription;
    private String appointmentLocation;
    private String appointmentType;
    private LocalDate appointmentStartTime;
    private LocalDate appointmentEndTime;
    private LocalDateTime appointmentStartDate;
    private LocalDateTime appointmentEndDate;
    private int customerId;
    private int userId;
    private int contactId;

    /**
     *
     * @param appointmentId INT value appointment ID
     * @param appointmentTitle String value appointment title
     * @param appointmentDescription String value appointment description
     * @param appointmentLocation String value appointment location
     * @param appointmentType String value appointment type
     * @param appointmentStartTime LocalDate value appointments start time
     * @param appointmentEndTime LocalDate value appointments end time
     * @param appointmentStartDate LocalDateTime value appointments start date
     * @param appointmentEndDate LocalDateTime value appointments start date
     * @param customerId INT value customer ID
     * @param userId INT value user ID
     * @param contactId INT value Contact ID
     */
    public Appointments(int appointmentId, String appointmentTitle, String appointmentDescription,
                        String appointmentLocation, String appointmentType, LocalDate appointmentStartTime,
                        LocalDate appointmentEndTime, LocalDateTime appointmentStartDate, LocalDateTime appointmentEndDate,
                        int customerId, int userId, int contactId){

        this.appointmentId = appointmentId;
        this.appointmentTitle = appointmentTitle;
        this.appointmentDescription = appointmentDescription;
        this.appointmentLocation = appointmentLocation;
        this.appointmentType = appointmentType;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.appointmentStartDate = appointmentStartDate;
        this.appointmentEndDate = appointmentEndDate;
        this.customerId = customerId;
        this.userId = userId;
        this.contactId = contactId;
    }

    /**
     * return appointment ID
     * @return appointment ID
     */
    public int getAppointmentId() {
        return appointmentId;
    }

    /**
     * sets appointment ID
     * @param appointmentId sets appointment id
     */
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * returns appointment title
     * @return appointment title
     */
    public String getAppointmentTitle(){
        return appointmentTitle;
    }

    /**
     * sets appointment title
     * @param appointmentTitle sets appointment title
     */
    public void setAppointmentTitle(String appointmentTitle) {
        this.appointmentTitle = appointmentTitle;
    }

    /**
     * returns appt description
     * @return returns appointment description
     */
    public String getAppointmentDescription(){
        return appointmentDescription;
    }

    /**
     * sets appointment description
     * @param appointmentDescription sets appointment description
     */
    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    /**
     * returns appointment location
     * @return appointment location
     */
    public String getAppointmentLocation() {
        return appointmentLocation;
    }

    /**
     * sets appointment location
     * @param appointmentLocation sets appointment location
     */
    public void setAppointmentLocation(String appointmentLocation) {
        this.appointmentLocation = appointmentLocation;
    }

    /**
     * returns appointment type
     * @return appt type
     */
    public String getAppointmentType(){
        return appointmentType;
    }

    /**
     * sets appointment type
     * @param appointmentType sets appointment type
     */
    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    /**
     * returns appointment start time
     * @return appointment start time
     */
    public LocalDate getAppointmentStartTime(){
        return appointmentStartTime;
    }

    /**
     * sets appointment start time
     * @param appointmentStartTime sets appointment start time
     */
    public void setAppointmentStartTime(LocalDate appointmentStartTime){
        this.appointmentStartTime = appointmentStartTime;
    }

    /**
     * returns appt end time
     * @return appt end time
     */
    public LocalDate getAppointmentEndTime() {
        return appointmentEndTime;
    }

    /**
     * sets appt end time
     * @param appointmentEndTime sets appt end time
     */
    public void setAppointmentEndTime(LocalDate appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    /**
     * returns appointment start date
     * @return appt start date
     */
    public LocalDateTime getAppointmentStartDate() {
        return appointmentStartDate;
    }

    /**
     * sets appointment start date
     * @param appointmentStartDate sets appointment start date
     */
    public void setAppointmentStartDate(LocalDateTime appointmentStartDate) {
        this.appointmentStartDate = appointmentStartDate;
    }

    /**
     * returns appointment end date
     * @return appt end date
     */
    public LocalDateTime getAppointmentEndDate() {
        return appointmentEndDate;
    }

    /**
     * sets appointment end date
     * @param appointmentEndDate sets appt end date
     */
    public void setAppointmentEndDate(LocalDateTime appointmentEndDate) {
        this.appointmentEndDate = appointmentEndDate;
    }

    /**
     * gets customer id
     * @return returns customer id
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * sets customer id
     * @param customerId sets customer id
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * returns user id
     * @return user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * sets user id
     * @param userId sets user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * returns contact ID
     * @return contact ID
     */
    public int getContactId() {
        return contactId;
    }

    /**
     * sets contact ID
     * @param contactId sets contact ID
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }


}
