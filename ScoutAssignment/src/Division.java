/**
 * A class to use as a template for a Division.
 *
 * @author Rachel Ryan 20089534
 * @version 1.0
 * @since 25/02/2020
 */

public class Division {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //1. Attributes / Fields

    /**
     * Represents the name of the division.
     */
    private String divisionName;
    /**
     * Represents the address of the division.
     */
    private String divisionAddress;
    /**
     * Represents the email of the division.
     */
    private String divisionEmail;
    /**
     * Represents the phone number of the division.
     */
    private String divisionPhone;
    /**
     * Represents the leader of the division.
     */
    private String divisionLeader;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //2. Constructor

    /**
     * Creating a new Division with the fields we have created.
     */
    public Division(String divisionName, String divisionAddress, String divisionEmail, String divisionPhone, String divisionLeader)
    {
        if (divisionName.length() <= 40) {
            this.divisionName = divisionName;
        } else {
            this.divisionName = "Maximum 40 characters.";
        }

        if (divisionAddress.length() <= 60) {
            this.divisionAddress = divisionAddress;
        } else {
            this.divisionAddress = "Must be less than 60 characters.";
        }

        if(divisionEmail.contains("@") && divisionEmail.contains(".")) {
            this.divisionEmail = divisionEmail;
        } else {
            this.divisionEmail = "invalid format email";
        }
        try {
            Long.parseLong(divisionPhone);
            this.divisionPhone = divisionPhone;
        } catch (NumberFormatException ex){
            this.divisionPhone = "unknown";
        }

        this.divisionLeader = divisionLeader;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //3. Getters

    /**
     * Getting the division name.
     */
    public String getDivisionName(){
        return divisionName;
    }

    /**
     * Getting the division address.
     */
    public String getDivisionAddress()
    {
        return divisionAddress;
    }

    /**
     * Getting the division email.
     */
    public String getDivisionEmail()
    {
        return divisionEmail;
    }

    /**
     * Getting the division phone.
     */
    public String getDivisionPhone()
    {
        return divisionPhone;
    }

    /**
     * Getting the division leader.
     */
    public String getDivisionLeader()
    {
        return divisionLeader;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //4. Setters

    /**
     * Setting the division name.
     */
    public void setDivisionName(String divisionName)
    {
        this.divisionName = divisionName;
    }

    /**
     * Setting the division address.
     */
    public void setDivisionAddress(String divisionAddress)
    {
        this.divisionAddress = divisionAddress;
    }

    /**
     * Setting the division email.
     */
    public void setDivisionEmail(String divisionEmail)
    {
        this.divisionEmail = divisionEmail;
    }

    /**
     * Setting the division phone number.
     */
    public void setDivisionPhone(String divisionPhone)
    {
        this.divisionPhone = divisionPhone;
    }

    /**
     * Setting the division leader.
     */
    public void setDivisionLeader(String divisionLeader)
    {
        this.divisionLeader = divisionLeader;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /**
     * String to list the division information.
     */
    public String toString() {

        return "Scouting Division Name = " + divisionName + ", Address: " +
                divisionAddress + ", Phone Number: " + divisionPhone +
                ", Division Leader: " + divisionLeader + ", Email: "
                + divisionEmail;
    }
}
