/**
 *  Name: AUSTIN MOSER (moser)
 *  Course: CSCI 241 - Computer Science I
 *  Section: 001
 *  Assignment: 2
 *
 * Project/Class Description:
 * This program asks the user for a 10 digit phone number
 * It breaks it apart and formats it with parentheses around
 * the area code and a dash before the last 4 digits.
 *
 * Known bugs: 
 * None.
 */

import java.util.*;

public class FormatPhone
{
    public static void main (String [] args)
    {
        // Create a new Scanner called input to store phoneDigits.
        Scanner input = new Scanner(System.in);
        
        // Input that asks user for a 10-digit number.
        System.out.print("Enter a 10-digit phone number without spaces: ");
        long phoneDigits = input.nextLong();
        
        // Finds areaCode for the phone number.
        long areaCode = phoneDigits / 10000000;
        
        // Removes the area code from the phone number.
        long holder1 = areaCode * 10000000;
        holder1 = phoneDigits - holder1;

        // Finds exchange for the phone number.
        long exchange = holder1 / 10000;
        
        // Removes the exchange from the phone number.
        long holder2 = exchange * 10000;
        
        // Finds extention for the phone number.
        long extention = holder1 - holder2;
        
        //Outputs the input that we used and the phone number.
        System.out.println("Original numbers entered: " + phoneDigits);
        System.out.println("Formatted phone number: (" + areaCode + ") " + exchange + "-" + extention);
    }
}