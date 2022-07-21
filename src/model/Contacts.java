package model;

public class Contacts {

    private int contactID;
    private String contactName;
    private String emailAddress;

    /**
     *
     * @param contactID INT value for contact id
     * @param contactName STRING value for contact name
     * @param emailAddress STRING value for email address
     */
    public Contacts(int contactID, String contactName, String emailAddress){
        this.contactID = contactID;
        this.contactName = contactName;
        this.emailAddress = emailAddress;
    }

    /**
     * getter for contact id
     * @return returns contact id
     */
    public int getContactID() {
        return contactID;
    }

    /**
     * getter for contact name
     * @return returns contact name
     */
    public String getContactName() {
        return contactName;
    }


    /**
     * getter for email address - unused
     * @return returns email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }


}
