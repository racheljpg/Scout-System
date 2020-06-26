/**
 * A class to use as a template for a Scout.
 *
 * @author Rachel Ryan 20089534
 * @version 1.0
 * @since 25/02/2020
 */

public class Scout {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //1. Attributes / Fields
    /**
     * Represents the division of the scout.
     */
    private Division division;
    /**
     * Represents the scouts first name.
     */
    private String Firstname;
    /**
     * Represents the scouts surname.
     */
    private String Surname;
    /**
     * Represents the gender of the scout.
     */
    private String gender;
    /**
     * Represents the scouts address.
     */
    private String address;
    /**
     * Represents the scouts day of birth.
     */
    private int dayOfBirth;
    /**
     * Represents the scouts month of birth.
     */
    private int monthOfBirth;
    /**
     * Represents the scouts year of birth.
     */
    private int yearOfBirth;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //2. Constructor

    /**
     * Creating a new Scout with the fields we have created.
     */
    public Scout(String Firstname, String Surname, String gender, String address,
                int dayOfBirth, int monthOfBirth, int yearOfBirth, Division division)
    {
        if (Firstname.length() <= 40) {
            this.Firstname = Firstname;
        } else {
            this.Firstname = "Maximum of 40 characters.";
        }

        if (Surname.length() <= 40) {
            this.Surname = Surname;
        } else {
            this.Surname = "Maximum of 40 characters.";
        }

        if (gender.equals("f")  || gender.equals("F") || gender.equals("m")
            || gender.equals("M") || gender.equals("unspecified") || gender.equals("Unspecified")) {
            this.gender = gender;
        } else {
            this.gender = "Invalid option.";
        }

        this.address = address;

        //I had || here instead of && but && is correct
        //as both conditions should be met to store a valid day of the month
        if (dayOfBirth >= 1 && dayOfBirth <= 31){
        this.dayOfBirth = dayOfBirth;
    } else {
            this.dayOfBirth = 1;
    }

        if (monthOfBirth >= 1 && monthOfBirth <= 12) {
            this.monthOfBirth = monthOfBirth;
        } else {
            this.monthOfBirth = 1;
        }

        this.yearOfBirth = yearOfBirth;

        this.division = division;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //3. Getters

    /**
     * Getting the division.
     */
    public Division getDivision()
    {
        return division;
    }

    /**
     * Getting the scouts gender.
     */
    public String getGender()
    {
        return gender;
    }

    /**
     * Getting the scouts year of birth.
     */
    public int getYearOfBirth()
    {
        return yearOfBirth;
    }

    /**
     * Getting the scouts month of birth.
     */
    public int getMonthOfBirth()
    {
        return monthOfBirth;
    }

    /**
     * Getting the scouts day of birth.
     */
    public int getDayOfBirth()
    {
        return dayOfBirth;
    }

    /**
     * Getting the scouts address.
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Getting the scouts surname.
     */
    public String getSurname()
    {
        return Surname;
    }

    /**
     * Getting the scouts first name.
     */
    public String getFirstname()
    {
        return Firstname;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //4. Setters

    /**
     * Setting the scouts division.
     */
    public void setDivision(Division division)
    {
        this.division = division;
    }

    /**
     * Setting the scouts gender.
     */
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    /**
     * Setting the scouts year of birth.
     */
    public void setYearOfBirth(int yearOfBirth)
    {
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * Setting the scouts month of birth.
     */
    public void setMonthOfBirth(int monthOfBirth)
    {
        this.monthOfBirth = monthOfBirth;
    }

    /**
     * Setting the scouts day of birth.
     */
    public void setDayOfBirth(int dayOfBirth)
    {
        this.dayOfBirth = dayOfBirth;
    }

    /**
     * Setting the scouts address.
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * Setting the scouts surname.
     */
    public void setSurname(String Surname)
    {
        this.Surname = Surname;
    }

    /**
     * Setting the scouts first name.
     */
    public void setFirstname(String Firstname)
    {
        this.Firstname = Firstname;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /**
     * String to list the scout information.
     */
    public String toString() {
        return "The scouts name is " + Firstname + " " + Surname + ", and they belong to the " + division.getDivisionName() + " division. Their address is "
        + address + ". They are " + gender + ". Their date of birth is "
                + dayOfBirth + "/" + monthOfBirth + "/" + yearOfBirth + ".";
    }
}
