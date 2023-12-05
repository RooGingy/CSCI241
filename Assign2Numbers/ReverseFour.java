/**
 *  Name: AUSTIN MOSER (moser)
 *  Course: CSCI 241 - Computer Science I
 *  Section: 001
 *  Assignment: 2
 *
 * Project/Class Description:
 * This program has the user input a 4 digit number. That number will then be reversed. So if you put 1234 it will be 4321.
 * Additionaly if the user puts less than 4 digits it will still run. So if you but in 89 it will be 9800.
 *
 * Known bugs: 
 * None.
 */

import java.util.*;

public class ReverseFour{
    public static void main(String[] args){
        //Instant Varibales:
        int originalNumber = 0;
        int moduledNumber = 0;
        int x = 0;
        int reversedNumber = 0;
        
        // Scanner that asks a question and reads user input.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer, no more than 4 digits: ");
        int number = input.nextInt();
        
        // Holds the four digits so that it can be displayed at the end for output.
        originalNumber = number;
        
        // A for loop that is looped 4 times. This will help when there is an input that has less than 4 numbers.
        for(int i = 0; i < 3; i++){
            // Number is moduled by 10 to get the last digit of the number.
            // That number is then divided by 10 to get the the next number that will be moduled when the loop repeats itself.
            moduledNumber = number % 10;
            number = number / 10;
            
            // The moduledNumber is then added to the the reversedNumber which is set to zero.
            // The reversedNumber is then multiplied by 10 so that the the next number can be added when the loop runs again.
            x = moduledNumber + reversedNumber;
            reversedNumber = x * 10;
        }
        
        // Gets the last digit of the number and added it to the reversed number. This is essential cause the loop does not add the last number on the end.
        moduledNumber = number % 10;
        number = number / 10;
        reversedNumber = reversedNumber + moduledNumber;
        
        //Outputs the original number and the reversed number
        System.out.println("Original number = " + originalNumber);
        System.out.println("Reversed number = " + reversedNumber);
    }
}
