package model;

public class Customers {

    private int customerID;
    private int customerPostalCode;
    private int divisionID;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private String divisionName;
    private String countryName;

    /**
     *
     * @param customerID customerID int
     * @param customerPostalCode customer postal code int
     * @param divisionID division ID int
     * @param customerName customer name string
     * @param customerAddress customer address string
     * @param customerPhoneNumber customer phone number string
     * @param divisionName customer division string
     * @param countryName customer country name string
     */
    public Customers(int customerID, int customerPostalCode, int divisionID, String customerName, String customerAddress,
                     String customerPhoneNumber, String divisionName, String countryName){
        this.customerID = customerID;
        this.customerPostalCode = customerPostalCode;
        this.divisionID = divisionID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.divisionName = divisionName;
        this.countryName = countryName;
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
    public int getCustomerPostalCode() {
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

    /**
     * returns division name
     * @return division name
     */
    public String getDivisionName(){
        return divisionName;
    }

    /**
     * sets division name
     */
    public void setDivisionName(){
        this.divisionName = divisionName;
    }

    /**
     * returns country name
     * @return country name
     */
    public String getCountryName(){
        return countryName;
    }

    /**
     * sets country name
     */
    public void setCountryName(){
        this.countryName = countryName;
    }
}
