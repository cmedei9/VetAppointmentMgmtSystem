package model;

public class Customers {

    private int customerID;
    private String customerPostalCode;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private int divisionID;
    private String country;
    private String divisionName;

    /**
     * @param customerID          customerID int
     * @param customerPostalCode  customer postal code int
     * @param divisionID          division ID int
     * @param customerName        customer name string
     * @param customerAddress     customer address string
     * @param customerPhoneNumber customer phone number string
     * @param country customer country name string
     * @param divisionName customers division name string
     */
    public Customers(int customerID, String customerPostalCode, int divisionID, String customerName, String customerAddress,
                     String customerPhoneNumber, String country, String divisionName){
        this.customerID = customerID;
        this.customerPostalCode = customerPostalCode;
        this.divisionID = divisionID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.country = country;
        this.divisionName = divisionName;
    }

    /**
     * returns customer id
     * @return customer id
     */
    public int getCustomerID(){
        return customerID;
    }

    /**
     * sets customer id
     */
    public void setCustomerID(){
        this.customerID = customerID;
    }

    /**
     * return customer postal code
     * @return customer postal code
     */
    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    /**
     * sets customer postal code
     */
    public void setCustomerPostalCode(){
        this.customerPostalCode = customerPostalCode;
    }

    /**
     * returns division ID
     * @return division ID
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     * sets division ID
     */
    public void setDivisionID(){
        this.divisionID = divisionID;
    }

    /**
     * returns customer name
     * @return customer name
     */
    public String getCustomerName(){
        return customerName;
    }

    /**
     * sets customer name
     */
    public void setCustomerName(){
        this.customerName = customerName;
    }

    /**
     * returns customer address
     * @return customer address
     */
    public String getCustomerAddress(){
        return customerAddress;
    }

    /**
     * sets customer address
     */
    public void setCustomerAddress(){
        this.customerAddress = customerAddress;
    }

    /**
     * returns customer phone number
     * @return customer phone number
     */
    public String getCustomerPhoneNumber(){
        return customerPhoneNumber;
    }

    /**
     * sets customer phone number
     */
    public void setCustomerPhoneNumber(){
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String countryID) {
        this.country = countryID;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

}
