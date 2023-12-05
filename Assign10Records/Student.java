
/**
 * Write a description of class Student here.
 *
 * @author AUSTIN MOSER (moser)
 * @version 11/20/2023
 */
public class Student
{
    // Instance Variables:
    private String lastName;
    private String firstName;
    private String id;
    private double gpa;

    /**
     * Default Constructor - for objects of class Student
     * <p>
     * This constructor sets everything to its defalts.
     * Ff its a a primative data tpye it will be = to 0,
     * or if its a string it will be set as "".
     */
    public Student()
    {
        // initialise instance variables
        this.lastName = "";
        this.firstName = "";
        this.id = "";
        this.gpa = 0.0;
    }

    /**
     * Class Constructor - for objects of class Student
     * <p>
     * (Long Description)
     * 
     * @param lName gets the last name of student
     * @param fName gets the fist name of student
     * @param x gets the ID of student
     * @param gradeAverage gets the gpa of student
     */
    public Student(String lName, String fName, String x, double gradeAverage)
    {
        // initialise instance variables
        this.lastName = lName;
        this.firstName = fName;
        this.id = x;
        this.gpa = gradeAverage;
    }

    /**
     * Returns the last name.
    * @return  the last name of the student
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Returns the first name.
     * @return  the first name of the student
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Returns the id.
     * @return  the id of the student
     */
    public String getID()
    {
        return id;
    }

    /**
     * Returns the gpa.
     * @return  the gpa of the student
     */
    public double getGpa()
    {
        return gpa;
    }
    
    /**
     * toString method:
     * <p>
     * This method takes all the data types and puts it
     * into a string that gets returned.
     * 
     * @param lName gets the last name of student
     * @param fName gets the fist name of student
     * @param x gets the ID of student
     * @param gradeAverage gets the gpa of student
     * 
     * @return  a string with last name, first name, id, and gpa.
     */
    public String toString(String lName, String fName, String x, double gradeAverage)
    {
        String fullName = fName + " " + lName;  // Combines fist name and last name to one sting.
        
        // Uses the combined string and justifies it left having a total of 20 charaters long.
        fullName = String.format("%-20s", fullName);    
        
        // Sets the string of id to have a fromat of 9 charater places,
        x = String.format("%9s", x);
        
        // Sets the double of gpa to have a 2 decimal places.
        String stringGpa = String.format("%.2f",gradeAverage);
        
        return fullName + x + " " + stringGpa;
    }
}
