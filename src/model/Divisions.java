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
     * returns division name
     * @return division name
     */
    public String getDivisionName(){
        return divisionName;
    }

    /**
     * returns country id - unused
     * @return country id
     */
    public int getCountryID(){
        return countryID;
    }

}
