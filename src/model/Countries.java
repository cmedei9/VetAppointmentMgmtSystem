package model;

public class Countries {

    private int countryID;
    private String countryName;

    /**
     *
     * @param countryID ID of the country
     * @param countryName Name of the country
     */
    public Countries(int countryID, String countryName){
        this.countryID = countryID;
        this.countryName = countryName;
    }

    /**
     * Returns the country ID - unused
     * @return country ID
     */
    public int getCountryID(){
        return countryID;
    }

    /**
     * Returns Country Name
     * @return country name
     */
    public String getCountryName(){
        return countryName;
    }

}
