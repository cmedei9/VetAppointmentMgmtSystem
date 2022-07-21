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
     * return customer postal code
     * @return customer postal code
     */
    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    /**
     * returns division ID - unused
     * @return division ID
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     * returns customer name
     * @return customer name
     */
    public String getCustomerName(){
        return customerName;
    }

    /**
     * returns customer address
     * @return customer address
     */
    public String getCustomerAddress(){
        return customerAddress;
    }

    /**
     * returns customer phone number
     * @return customer phone number
     */
    public String getCustomerPhoneNumber(){
        return customerPhoneNumber;
    }

    /**
     * returns customer country
     * @return customer country
     */
    public String getCountry() {
        return country;
    }

    /**
     * setter for customer country
     * @param countryID country ID
     */
    public void setCountry(String countryID) {
        this.country = countryID;
    }

    /**
     * returns customers division name
     * @return customers division name
     */
    public String getDivisionName() {
        return divisionName;
    }


}
