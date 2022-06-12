package model;

public class Divisions {

    private int divisionID;
    private int countryID;
    private String divisionName;


    /**
     *
     * @param divisionID division ID
     * @param divisionName division name
     * @param countryID  country ID
     */
    public Divisions(int divisionID, String divisionName, int countryID){
        this.divisionID = divisionID;
        this.divisionName = divisionName;
        this.countryID = countryID;
    }

    /**
     * returns division ID
     * @return returns division ID
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     * sets division id
     * @param divisionID sets division id
     */
    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
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
     * @param divisionName sets division name
     */
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    /**
     * returns country id
     * @return country id
     */
    public int getCountryID(){
        return countryID;
    }

    /**
     * set country id
     * @param countryID sets country id
     */
    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }
}
