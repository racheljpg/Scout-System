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

public class DivisionList {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //1. Attributes / Fields
    /**
     * Creating the ArrayList for the divisions.
     */
    private ArrayList<Division> divisions;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //2. Constructor

    /**
     * Constructor - initialise the ArrayList division list.
     */
    public DivisionList()
    {
        divisions = new ArrayList<Division>();
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //3. Methods

    /**
     * Adding a division to our ArrayList.
     */
    public void addDivision(Division division)
    {
        divisions.add(division);
    }

    /**
     * Method to get a division.
     */
    public Division getDivision(int index)
    {
        return divisions.get(index);
    }

    /**
     * Method to return number of divisions.
     */
    public int numberOfDivisions() {
        int count = 0;
        for (int i = 0; i < divisions.size(); i++) {
            count++;
        }
        return count;
    }

    /**
     * Method to list our divisions.
     */
    public String listOfDivisions(){
        if (divisions.size() == 0) {
            return "No divisions yet.";
        } else {
            String listOfDivisions = "";
            for (int i = 0; i < divisions.size(); i++){
                listOfDivisions = listOfDivisions + i + ": " + divisions.get(i) + "\n";
            }
            return listOfDivisions;
        }
    }

    /**
     * Method to return the number of elements in the ArrayList.
     */
    public int getSize()
    {
        return divisions.size();
    }

    /**
     * Method to remove a division by index.
     */
    public void removeDivision(int index)
    {
        divisions.remove(index);
    }

    /**
     * Method to save our divisions.
     */
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("divisions.xml"));
        out.writeObject(divisions);
        out.close();
    }

    /**
     * Method to load our divisions.
     */
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("divisions.xml"));
        divisions = (ArrayList<Division>) is.readObject();
        is.close();
    }
}
