import java.util.Scanner;

/**
 * This class runs the scouting system and handles the scouts and divisions
 * @author Rachel Ryan 20089534
 * @version 1.0
 * @since 01/03/2020
 */

public class ScoutingSystem {
    /**
     * Declares and initialises a private Scanner object called input.
     * Declares a private ScoutList object called scoutList.
     */
    private Scanner input = new Scanner(System.in);
    private ScoutList scoutList;
    private DivisionList divisionList;

    /**
     * Constructor - initialises the scoutList object.
     * Calls the runMenu() method
     */
    public ScoutingSystem() {
        scoutList = new ScoutList();
        divisionList = new DivisionList();
        runMenu();
    }

    public static void main(String[] args) {
        new ScoutingSystem();
    }

    /**
     * mainMenu() - This displays the menu for the scouting system,
     * reads the menu option the user picks and returns it.
     */

    private int mainMenu() {
        System.out.println("Welcome to the Scouting System:");
        System.out.println("--------------------------------");
        System.out.println("Please select a following option:");
        System.out.println("1) Add a Scouting Division");
        System.out.println("2) List all Divisions");
        System.out.println("3) Remove a Division (by index)");
        System.out.println("--------------------------------");
        System.out.println("4) Add a Scout");
        System.out.println("5) List all Scouts");
        System.out.println("6) List all Scouts by Gender");
        System.out.println("7) List all Scouts by Division");
        System.out.println("8) Remove a Scout (by index)");
        System.out.println("--------------------------------");
        System.out.println("Save to XML");
        System.out.println("Load from XML");
        System.out.println("--------------------------------");

        System.out.println("0 - To Exit");
        System.out.println("===: ");
        int option = input.nextInt();
        return option;
    }

    /**
     * Calls mainMenu() and takes the value returned from the mainMenu() and uses
     * it for the switch statement.
     */
    private void runMenu() {
        int option = mainMenu();
        while (option !=0) {
            switch (option) {
                case 1:
                        addDivision();
                        break;
                case 2:
                        System.out.println(divisionList.listOfDivisions());
                        break;
                case 3:
                        deleteDivision();
                        break;
                case 4:
                        addScout();
                        break;
                case 5:
                        printScouts();
                        break;

                case 6:
                        listScoutByGender();
                        break;
                case 7:
                        listScoutByDivision();
                        break;
                case 8:
                        deleteScout();
                        break;
                case 9:
                    try{
                        scoutList.save();
                        divisionList.save();
                    }
                    catch(Exception e){
                        System.out.println("Error writing to file: " + e);
                    }
                    break;
                case 10:
                    try{
                        scoutList.load();
                        divisionList.load();
                    }
                    catch(Exception e){
                        System.out.println("Error loading from file: " + e);
                    }
                    break;

                default:
                        System.out.println("Invalid option entered: " + option);
                        break;
            }

            //Pause the program so the user can read choices and select
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine(); //second line to fix bug in Scanner class
            //displaying main menu again
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting system... bye!");
        System.exit(0);
    }

    /**
     * Gather the Scout data from the user and create a new scout.
     */
    private void addScout(){
        //to fix bug in Scanner class
        input.nextLine();
        System.out.println("Enter the Scouts First Name (Max 40 characters)");
        String Firstname = input.nextLine();
        while(Firstname.length() > 40){
            System.out.println("Maximum 40 characters. Please enter again.");
            Firstname = input.nextLine();
        }

        System.out.println("Enter the Scouts Last Name (Max 40 characters)");
        String Surname = input.nextLine();
        while(Surname.length() > 40){
            System.out.println("Maximum 40 characters. Please enter again.");
            Surname = input.nextLine();
        }

        System.out.println("Enter the Scouts gender: ");
        System.out.println("M");
        System.out.println("F");
        System.out.println("or");
        System.out.println("Unspecified.");
        String gender = input.nextLine();
        //Tried to add validation to this but for some reason it kept giving the error message
        // - Can't figure out why :(
        //while(!gender.equals("f")  || !gender.equals("F") || !gender.equals("m")
        //        || !gender.equals("M") || !gender.equals("unspecified") || !gender.equals("Unspecified")){
        //    System.out.println("Invalid option. Please enter again.");
        //    gender = input.nextLine();
        //}

        System.out.println("Enter the scouts address: ");
        String address = input.nextLine();

        System.out.println("Enter the Scouts day of birth: ");
        int dayOfBirth = input.nextInt();
        while(dayOfBirth < 1 || dayOfBirth > 31){
            System.out.println("Please enter a valid day of birth.");
            dayOfBirth = input.nextInt();
        }

        System.out.println("Enter the Scouts month of birth: ");
        int monthOfBirth = input.nextInt();
        while(monthOfBirth < 1 || monthOfBirth > 12){
            System.out.println("Please enter a valid month.");
            monthOfBirth = input.nextInt();
        }

        System.out.println("What is the current year?");
        int currentYear = input.nextInt();
        System.out.println("Enter the Scouts year of birth: ");
        int yearOfBirth = input.nextInt();
        while (currentYear-yearOfBirth <=6) {
            System.out.println("Must be 6 years old to use. Try again.");
            System.out.println("Enter the Scouts year of birth: ");
            yearOfBirth = input.nextInt();
        }

        String divisionDetails = divisionList.listOfDivisions();
        System.out.println(divisionDetails);
        int size = divisionList.numberOfDivisions();
        if (size > 0){
            System.out.println("Please enter the index of the Scouts Division.");
            Division division = divisionList.getDivision(input.nextInt());
            Scout scout = new Scout(Firstname, Surname, gender, address, dayOfBirth, monthOfBirth, yearOfBirth, division);
            scoutList.addScout(scout);
        } else {
            System.out.println("Please create a new Division: ");
            Division division = addDivision();
            Scout scout = new Scout(Firstname, Surname, gender, address, dayOfBirth, monthOfBirth, yearOfBirth, division);
            scoutList.addScout(scout);
        }
    }

    /**
     * Print the Scout using toString.
     */
    private void printScouts(){
        System.out.println("List of Scouts are: ");
        System.out.println(scoutList.listOfScouts());
    }

    /**
     * Method to update the scouts attributes as long as the ArrayList is not empty.
     */
    private void updateScout() {
        //list the scouts to the screen
        String scoutDetails = scoutList.listOfScouts();
        System.out.println(scoutDetails);

        int size = scoutList.getSize();

        if (!scoutDetails.equals("No scouts")) {
            //ask the user to choose a scout
            System.out.println("Enter the index of the product to update ==> ");
            int index = input.nextInt();
            if (size > 0 && (index < size)) {

                //gather new details for each field from the user
                input.nextLine(); //bug in Scanner class
                System.out.println("Enter the Scouts first name: ");
                String Firstname = input.nextLine();
                System.out.println("Enter the Scouts surname: ");
                String Surname = input.nextLine();
                System.out.println("Enter the Scouts gender: ");
                String gender = input.nextLine();
                System.out.println("Enter the Scouts address: ");
                String address = input.nextLine();
                System.out.println("Enter the Scouts day of birth: ");
                int dayOfBirth = input.nextInt();
                System.out.println("Enter the Scouts month of birth: ");
                int monthOfBirth = input.nextInt();
                System.out.println("Enter the Scouts year of birth: ");
                int yearOfBirth = input.nextInt();


                System.out.println("Scout updated successfully.");
            } else {
                System.out.println("Incorrect Index - no Scout exists for that index.");
            }
        }
    }

    /**
     * This method deletes a Scout object as long as the ArrayList is not empty.
     */
    private void deleteScout(){
        //list the Scouts to the screen
        String scoutDetails = scoutList.listOfScouts();
        System.out.println(scoutDetails);
        //Get the number of the elements in the ArrayList
        int size = scoutList.getSize();

        if(!scoutDetails.equals("No scouts."))
        {
            //ask the user to choose a scout
            System.out.println("Enter the index of the scout to Delete ==> ");
            int index = input.nextInt();
            if (size > 0 && (index < size)) {

                scoutList.deleteScout(index);
                System.out.println("Scout successfully removed.");
            }
             else {

                System.out.println("Incorrect Index - no scouts exist for this index.");
            }
        }
    }

    /**
     * Method to add a new division to the ArrayList.
     */
    private Division addDivision(){

        //to fix bug in Scanner class
        input.nextLine();
        System.out.println("Enter the Divisions name (Max 40 characters)");
        String divisionName = input.nextLine();
        while(divisionName.length() > 40){
            System.out.println("Cannot be longer than 40 characters. Please enter again.");
            divisionName = input.nextLine();
        }

        System.out.println("Enter the Divisions address (Max 60 characters)");
        String divisionAddress = input.nextLine();
        while(divisionAddress.length() > 60){
            System.out.println("Cannot be longer than 60 characters. Please enter again.");
            divisionAddress = input.nextLine();
        }

        System.out.println("Enter the Divisions email (Must contain @ symbol and .)");
        String divisionEmail = input.nextLine();
        while(!divisionEmail.contains("@") && !divisionEmail.contains(".")){
            System.out.println("Invalid email. Please enter again.");
            divisionEmail = input.nextLine();
        }

        //Not sure how to add the validation in a while loop here since it is
        //a try catch in the validation in the constructor
        System.out.println("Enter the Divisions phone: ");
        String divisionPhone = input.nextLine();


        System.out.println("Enter the Divisions leader:  ");
        String divisionLeader = input.nextLine();


        Division d1 = new Division(divisionName, divisionAddress, divisionEmail,
                            divisionPhone, divisionLeader);
        divisionList.addDivision(d1);

        return new Division(divisionName, divisionAddress, divisionEmail,
                divisionPhone, divisionLeader);
    }

    /**
     * Method to delete a division using the index.
     */
    private void deleteDivision() {
        //list the divisions to the screen
        String divisionDetails = divisionList.listOfDivisions();
        System.out.println(divisionDetails);
        //Get the number of elements in the ArrayList to ensure correct index is entered
        int size = divisionList.getSize();

        if(!divisionDetails.equals("No divisions yet."))
        {
            //ask the user to choose a scout
            System.out.println("Enter the index of the Division to delete ==> ");
            int index = input.nextInt();
            if ( size > 0 && (index < size))
            {
                divisionList.removeDivision(index);
                System.out.println("Division successfully removed.");
            }
            else
            {
                System.out.println("Incorrect Index - no Division exists for this index.");

            }
        }
    }

    /**
     * Method to call the method from ScoutLIst to list all scouts assigned to a certain gender.
     */
    private void listScoutByGender() {
        //list the  to the screen
        System.out.println("Which gender do you want to search by? Please choose M or F.");
        char ans = input.next().toUpperCase().charAt(0);
        if (ans == 'F'){
            System.out.println(scoutList.listScoutsBySpecificGender("F"));
        } else if (ans == 'M'){
            System.out.println(scoutList.listScoutsBySpecificGender("M"));
        } else {
            System.out.println("There are no scouts with the assigned gender: " + ans);
        }
    }

    /**
     * Method to call the method from ScoutList to list all scouts assigned to a certain division.
     */
    private void listScoutByDivision(){
        System.out.println("Enter which division you would like to see the scouts in: ");
        input.nextLine();
        String Division = input.nextLine();
        System.out.println(scoutList.listScoutsBySpecificDivision(Division));
    }

}
