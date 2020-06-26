import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * A class to build an ArrayList for the divisions.
 *
 * @author Rachel Ryan 20089534
 * @version 1.0
 * @since 27/02/2020
 */

public class ScoutList {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //1. Attributes / Fields
    /**
     * Creating the ArrayList for the scouts.
     */
    private ArrayList<Scout> scouts;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //2. Constructor
    /**
     * Constructor - initialise the ArrayList.
     */
    public ScoutList()
    {
        scouts = new ArrayList<Scout>();
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //3. Methods

    /**
     * Adding a scout to our ArrayList.
     */
    public void addScout(Scout scout)
    {
        scouts.add (scout);
    }

    /**
     * Method to update a Scout object in the ArrayList.
     */
    public void updateScout(int index, Division division, String Firstname, String Surname, String gender,
                            String address, int dayOfBirth, int monthOfBirth, int yearOfBirth)
    {
        Scout s = scouts.get(index);
        s.setDivision(division);
        s.setFirstname(Firstname);
        s.setSurname(Surname);
        s.setGender(gender);
        s.setAddress(address);
        s.setDayOfBirth(dayOfBirth);
        s.setMonthOfBirth(monthOfBirth);
        s.setYearOfBirth(yearOfBirth);
    }

    /**
     * Method to remove a Scout object from the ArrayList.
     */
    public void deleteScout(int index)
    {
        scouts.remove(index);
    }

    /**
     * Method to return the number of elements in the ArrayList.
     * with string.
     */
    public String numberOfScouts()
    {
        return "We have " + scouts.size() + " scouts.";
    }

    /**
     * Method to return the number of elements in the ArrayList.
     */
    public int getSize()
    {
        return scouts.size();
    }

    /**
     * Method to build and return a String with all the scout objects in the ArrayList.
     */
    public String listOfScouts(){
        if (scouts.size() == 0) {
            return "No scouts.";
        } else {
            String listOfScouts = "";
            for (int i = 0; i < scouts.size(); i++){
                listOfScouts = listOfScouts + i + ": " + scouts.get(i) + "\n";
            }
            return listOfScouts;
        }
    }

    /**
     * Method to save our scouts to our ArrayList.
     */
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("scouts.xml"));
        out.writeObject(scouts);
        out.close();
    }

    /**
     * Method to load our scouts from our xml file.
     */
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("scouts.xml"));
        scouts = (ArrayList<Scout>) is.readObject();
        is.close();
    }

    /**
     * Method to round a number to two decimal places.
     */
    private double toTwoDecimalPlaces(double num)
    {
        return (int) (num *100) /100.0;
    }

    /**
     * Method to list all Scouts by their assigned gender.
     */
    public String listScoutsBySpecificGender(String gender) {

        if(scouts.size() == 0) {
            return "There are no scouts in the list yet.";
        } else {

            String listOfScoutsByGender = "";

            for (int i = 0; i < scouts.size(); i++) {

                if (scouts.get(i).getGender().toUpperCase().contains(gender.toUpperCase()))

                    listOfScoutsByGender += scouts.toString() + "\n";
            }
            if (listOfScoutsByGender.isEmpty()){
                listOfScoutsByGender = "There are no scouts with the gender " + gender;
            }

                return listOfScoutsByGender;
            }
        }

    /**
     * Method to list all Scouts by their assigned Division.
     */
    public String listScoutsBySpecificDivision(String Division){

        if(scouts.size() == 0){
            return "There are no scouts in the list yet.";
        } else {

            String listOfScoutsByDivision = "";

            for(int i = 0; i < scouts.size(); i++) {

                if (scouts.get(i).getDivision().getDivisionName().contains(Division))
                listOfScoutsByDivision += scouts.toString() + "\n";
            }

            if(listOfScoutsByDivision.isEmpty()){

                listOfScoutsByDivision = "There are no scouts in the division: " + Division;

            }
            return listOfScoutsByDivision;
        }
    }
}
