/**
 *  Name: Erica Eddy
 *  Course: CSCI 241 - Computer Science I
 *  Section: 001 or 002
 *  Assignment: 10
 *
 *  Project/Class Description
 *      This is a test driver for the Assignment 10.
 *      Your instructor will use a different file when
 *      actually testing your code.
 *
 *  Known Bugs: none
 */
import java.util.*;

public class Assign10Main
{
    public static void main (String [] args) throws Exception
    {
        // The shorter data file
        String filename = "studentTest.txt";
        
        // Our Registrar object
        Registrar reg = new Registrar (filename);
        
        // Test some of the Registrar methods.
        System.out.println("All Students");
        System.out.println("---------------------------------");
        reg.printList();
        
        System.out.println();
        System.out.println();
        
        System.out.println("Dean's List");
        System.out.println("---------------------------------");
        reg.printDeansList();
        
        System.out.println();
        System.out.println();

        reg.findStudent("Winston", "George");
        reg.findStudent("McGee", "Shirley");
        
        System.out.println("Time to add a student:");
        reg.addStudent();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Searching for a last name");
        System.out.print("Enter the last name to find: ");
        String lastName = keyboard.nextLine();        
        reg.findLastName(lastName);
        
        System.out.println("Searching for a particular student");
        System.out.print("Enter the last name to find: ");
        lastName = keyboard.nextLine();
        System.out.print("Enter the first name to find: ");
        String firstName = keyboard.nextLine();
        reg.findStudent(lastName, firstName);
    }
}