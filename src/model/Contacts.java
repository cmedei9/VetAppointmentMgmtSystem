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
     * setter for contact id
     * @param contactID sets value for contact id
     */
    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    /**
     * getter for contact name
     * @return returns contact name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * setter for contact name
     * @param contactName sets value for contact name
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * getter for email address
     * @return returns email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * setter for email address
     * @param emailAddress sets value for email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
