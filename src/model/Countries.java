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
     * Returns the country ID
     * @return country ID
     */
    public int getCountryID(){
        return countryID;
    }

    /**
     * sets country ID
     * @param countryID sets country ID
     */
    public void setCountryID(int countryID){
        this.countryID = countryID;
    }

    /**
     * Returns Country Name
     * @return country name
     */
    public String getCountryName(){
        return countryName;
    }

    /**
     * sets country name
     * @param countryName sets country name
     */
    public void setCountryName(String countryName){
        this.countryName = countryName;
    }
}
