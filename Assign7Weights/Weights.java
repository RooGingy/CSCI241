/**
 * Name:  AUSTIN MOSER (moser)
 * Course:  CSCI-241 - Computer Science I
 * Section: 001
 * Assignment: 7
 * 
 * Project/Class Description:
 * Print original weight in columns of 5.
 * Convert ounces to pounds/ounces.
 * Get the tolal of all the weight ounces to pounds.
 * See if what weights are over the limit.
 * Group the weight in 5 seperate block catagories.
 * 
 * Known Bugs:
 * none
 * 
 */

import java.util.*;

public class Weights {
    public static void main (String[] args) {
        // make an array that holds 12 different integers representing ounces
        int[] myWeights = {258, 58, 209, 91, 79, 182, 172, 27, 7, 29, 128, 198};
        
        // Ask the user whether to use fixed array or a new one of random size
        System.out.print("Enter 1 for fixed 12-element array, 2 for random array: ");
        Scanner input = new Scanner(System.in);
        int selection = input.nextInt();
        System.out.println();   //Empty line.
        
        // If the select option 2 it will let the user create a new array.
        if (selection == 2) {
            // Asks the user to input how many elements they want in the new array.
            System.out.print("Enter # of elements in array: ");
            int numberOfElements = input.nextInt();
            System.out.println();   //Empty line.
           
            // Stores the new number of elements in the myWeights.
            myWeights = new int[numberOfElements];
            
            // For loop that assigns a random number to each new element of myWeights.
            for(int i = 0; i < numberOfElements; i++){
                // Generates a random number between 1 and 320.
                myWeights[i] = 1 + (int)(Math.random() * 320) + 1;
            }
        }
        
        // Prints original array with ounces values
        System.out.println("Printing original weights");
        System.out.print("-------------------------");
        
        // Calls the printArrayValues() method to print the values in the array
        System.out.println(printArrayValues(myWeights));
        System.out.println();   //Empty line.

        // Prints the values in the array, as pound/ounce combinations
        System.out.println("Printing original weights in pound/ounce form");
        System.out.println("---------------------------------------------");
        
        // Calls the printWeights() method to print values in pound/ounce format
        System.out.print(printWeights(myWeights));
        System.out.println();   //Empty line.

        // Adds all weights and print the sum
        System.out.println("Weights in this array total over " + sumWeights(myWeights) + " pounds");
        System.out.println();   //Empty line.
       
        // Finds all weights that exceed 8 pounds, return that array, and print it
        int[] over = overGivenPounds(8, myWeights);
        
        // print the values in the array, as pound/ounce combinations
        System.out.println("Printing Weights over 8 Pounds");
        System.out.println("------------------------------"); 
        
        // Calls the printWeights() method to print the over array values in pound-ounce format.
        System.out.println(printWeights(over));
        System.out.println();   //Empty line.

        // Calls method to fill in blocks array.
        int[] blocks = blocks(myWeights);
       
        // Prints the blocks array.
        System.out.println("Printing blocks (4 pound increments) ...");
        System.out.println();   //Empty line.
        System.out.println("1st  2nd  3rd  4th  5th");
        System.out.print("---  ---  ---  ---  ---");
        
        // Prints the blocks array contents, using printArrayValues.
        System.out.println(printArrayValues(blocks));
        System.out.println();   //Empty line.
    }

    // This method takes an array and returns it to a singlar string.
    public static String printArrayValues(int[] array) {
        String s1 = "";
        
        for(int i = 0; i < array.length; i++) {
            //This if statement takes 5 elements of an array at a time a time and combine it all at in one line.
            if(i % 5 != 0) {
                s1 += String.format("%5s", array[i]);
            }
            // Once the i % 5 has 0 remainders it will print a new line as well as the next element of the array.
            else {
                s1 += String.format("\n%3s", array[i]);
            }
        }
        return s1;  // After the last element of the array it will store the stingle string as the return.
    }
    
    // This method converts ounces to pounds/ounces.
    public static String printWeights(int[] array) {
        String s1 = "";
        
        for(int i = 0; i < array.length; i++) {
            // Caculate total pounds.
            int pounds = array[i] / 16;
            
            // Calulate remainding ounces.
            int remaindingOunces = (int)(array[i] % 16);
            
            // Creates a string the shows how many pounds and remaindingOunces that are in some number of ounces.
            s1+= String.format("%3s", array[i]) + " ounces =" + String.format("%3s",pounds) + " lbs," + String.format("%2s",remaindingOunces) + " oz.\n";
        }
        return s1;
    }
    
    // This method adds the total ounces can converts it to pounds as an int type.
    public static int sumWeights(int[] array) {
        int sum = 0;
        
        // Adds each element of array to sum.
        for(int i = 0; i < array.length; i++) {
            sum+= array[i];
        }
        return sum/= 16;    // Takes the total of sum and divide it by 16 to get total pounds.
    }
    
    // This method finds all the weights that is over a certain limit.
    public static int[] overGivenPounds(int limit, int[] array) {
        int count = 0;
        
        // For loop to see how many elements of the array is over the limit.
        for(int i = 0; i < array.length; i++) {
            // Divides the ounces from the element by 16 to get the pounds.
            int pounds = array[i] / 16;
            
            // If pounds it over the limit then count goes up one.
            if (pounds > limit) {
                count++;
            }
        }
        
        // Uses count to then initialize how many elements overTheLimit needs to hold.
        int[] overTheLimit = new int[count];
        count = 0;  // Resets count so we can assign each element.
        
        // Assings each element with what was over the limit. 
        for(int i = 0; i < array.length; i++) {
            // Divides the ounces from the element by 16 to get the pounds.
            int pounds = array[i] / 16;
        
            // If pounds it over the limit then the array is assigned to one of the elements in over the limit.
            if (pounds > limit) {
                overTheLimit[count] = array[i];
                count++;
            }
        }
        return overTheLimit;
    }
    
    // This method counts how many weights are in each set block.
    public static int[] blocks(int[] array) {
        int[] blockArray = new int[5];
        
        // Counts how many weight are in set block.
        for(int i = 0; i < array.length; i++) {
            if(array[i] >= 256) {
                blockArray[4] += 1;
            }
            else if(array[i] >= 192) {
                blockArray[3] += 1;
            }
            else if(array[i] >= 128) {
                blockArray[2] += 1;
            }
            else if(array[i] >= 64) {
                blockArray[1] += 1;
            }
            else {
                blockArray[0] += 1;
            }
        }
        return blockArray;
    }
}
