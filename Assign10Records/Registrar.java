
/**
 * AUSTIN MOSER (moser)
 * Course: CSCI 241 - Computer Science I
 * Section: 001 or 002
 * Assignment: 1
 *
 * Project/Class Description:
 *  Print list of 100 students and there data.
 *  Print the list of dean students.
 *  Have user add a student.
 *  Have user search for students using first and last name.
 *  Have user search for students using last name.
 *
 *  Known Bugs: none
 */

import java.io.*;
import java.util.*;

public class Registrar
{
    // Instance Variables:
    private Student[] student;
    private int filledPositions = 0;
    private boolean arrayFilled = false;    // added an extra instance just to try an extra thing in the code. All functions should still work in the assignment.

    /**
     * Constructor for objects of class Registrar:
     * <p>
     * This constructor takes in a parameter data from a file and splits each line
     * of the file into 4 parts: first name, last name, id, gpa.
     *
     *@param data takes in the name of a data file
     */
    public Registrar(String data) throws Exception{
        // Create a list to read student data into it.
        List<String> listOfStudentData = new ArrayList<String>();

        // Set the amount of studend object to 100;
        student = new Student[100];

        // Loads data from file.
        BufferedReader bf = new BufferedReader(new FileReader(data));

        // Holds the first line of student data
        String studentData = bf.readLine();
        while (studentData != null) {   // checks if line holds data
            // Stores the line of of student data.
            listOfStudentData.add(studentData);

            // Increments filled posiotion.
            filledPositions++;

            // Goes to the next line of file and reads it into studentData.
            studentData=bf.readLine();
        }
        // Closes file
        bf.close();

        // Converst the List to a String Array.
        String[] StudentDataArr = listOfStudentData.toArray(new String[0]);

        for(int i = 0; i < filledPositions; i++){
            if(i < student.length){
                // gets the first name of the the string;
                String fullname = StudentDataArr[i].substring(0,20);

                // Removes the quotation marks form the string.
                fullname = fullname.replace("\"", "");

                // Trims off the extra white spaces from the string.
                fullname = fullname.trim();

                // Split the string at the comma to get the first and last name.
                String[] name = fullname.split(", ");
                String lastName = name[0];
                String firstName = name[1];

                String id = StudentDataArr[i].substring(21,29);
                String gpa = StudentDataArr[i].substring(31,StudentDataArr[i].length());

                //converts string to double for gpa
                double gpaToDouble = Double.parseDouble(gpa);

                student[i] = new Student(lastName,firstName,id,gpaToDouble);
            }
            else{
                arrayFilled=true;
                break;
            }
        }
    }

    /**
     * Prints list of all students:
     * <p>
     * Prints the list of students data using the toString method thats created.
     */
    public void printList(){
        for(int i=0; i<student.length; i++){
            if(student[i] != null){
                System.out.println(student[i].toString(
                        student[i].getLastName(), 
                        student[i].getFirstName(),
                        student[i].getID(),
                        student[i].getGpa()
                    ));
            }
        }
        // Prints error message if the array is already filled;
        System.out.println(isArrayFilled(arrayFilled));
    }

    /**
     * Prints deans list:
     * <p>
     * Prints the list of students data that has a gpa of 3.5 or higher
     * using the toString method thats created.
     */
    public void printDeansList(){
        for(int i=0; i < student.length; i++){
            if(student[i] != null){
                if(student[i].getGpa()>=3.5){
                    System.out.println(student[i].toString(
                            student[i].getLastName(), 
                            student[i].getFirstName(),
                            student[i].getID(),
                            student[i].getGpa()
                        ));
                }
            }
        }
    }

    /**
     * Find Student with first and last name:
     * <p>
     * Goes through the list of student data finding the student with the same
     * first ans last name.
     * 
     * @param lastName gets the last name of student
     * @param firstName gets the fist name of student
     */
    public void findStudent(String lastName, String firstName)
    {
        /* 
         * Compare the parameter of first and last name with first and last
         * names from the list of students. If the name maches it will print the
         * students data with the to string method that was created.
         */
        for(int i = 0; i < student.length; i++){
            if(student[i] != null){
                if(firstName.equals(student[i].getFirstName()) &&
                lastName.equals(student[i].getLastName())){
                    System.out.println(student[i].toString(
                            student[i].getLastName(), 
                            student[i].getFirstName(),
                            student[i].getID(),
                            student[i].getGpa()
                        ));
                }
            }
        }
    }

    /**
     * Finds alls students with the same last name:
     * <p>
     * Goes through the list of student data finding the student 
     * with the same last name.
     * 
     * @param lastName gets the last name of student
     */
    public void findLastName(String lastName)
    {
        for(int i = 0; i < student.length; i++){
            if(student[i] != null && lastName.equals(student[i].getLastName())){
                System.out.println(student[i].toString(
                        student[i].getLastName(), 
                        student[i].getFirstName(),
                        student[i].getID(),
                        student[i].getGpa()
                    ));
            }
        }
    }

    /**
     * Adds a new student
     * <p>
     * If the array is already filled then it will skip the part in asking to enter data and print an error message
     */
    public void addStudent()
    {
        /// Checks if the array is alreay is not filled.
        if(arrayFilled==false){
            Scanner scanner = new Scanner(System.in);
            String firstName;
            String lastName;
            String id;
            double gpa;
            
            // Ask for student first name.
            System.out.print("Enter student last name: ");
            lastName=scanner.next();
            
            // Ask for student last name.
            System.out.print("Enter student first name: ");
            firstName=scanner.next();

            // Have a loop that makes sure that the student id have 9 charater in length.
            do{
                // Ask for student ID.
                System.out.print("Enter student ID: ");
                id=scanner.next();
            } while(id.length()>9);

            // Have a loop that makes check if gpa is not out of bounds between 0 and 4.
            do{
                // Ask for student gpa.
                System.out.print("Enter student gpa: ");
                gpa=scanner.nextDouble();
            } while(gpa < 0 || gpa > 4);

            student[filledPositions] = new Student(lastName,firstName,id,gpa);
            filledPositions++;
        }
        // if student array is full error message prints.
        else{
            System.out.println(isArrayFilled(arrayFilled));
        }
    }

    /**
     * Error Message - Filled Array
     * <p>
     * If the array is marked filled when it it will print a error message
     * 
     * @param filled gets a true or false value if the array is filled.
     * @return this returns the error message or nothing.
     */
    private String isArrayFilled(boolean filled){
        if(filled == true){
            return "Error: List has reached its max length of " + student.length +" students";
        }
        return null;
    }
}
