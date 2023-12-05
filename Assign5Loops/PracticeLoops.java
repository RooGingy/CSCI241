
/**
* Name: AUSTIN MOSER (moser)
* Course: CSCI 241 - Computer Science I
* Section: 005
* Assignment: 5
*
* Project/Class Description:
* Uses different types of loops to do different types of things.
*
* Known bugs:
* none
* 
*/

import java.util.*;

public class PracticeLoops{
    public static void main(String[] agrs){
        Scanner input = new Scanner(System.in);
        
        // Section A Header:
        System.out.println("          ------ Section A ------");
        System.out.println("User enters a number between 2 and 10, inclusive.");
        System.out.println("Loop runs to place that many spaces between \"Hello\" and \"Goodbye\".");
        System.out.println("Loop runs to find that number's factorial value.");
        System.out.println("========================================================================");
        
        // Input for Section A:
        // Lets the user enter a number.
        System.out.print("Enter a number to use for factorial: ");
        int userInput = input.nextInt();
        
        // While number is less than 2 or greater than 10 it will print an error meesage and ask the user to try again.
        do{
            if(userInput < 2 || userInput > 10){
                System.out.println("Error: factorial number must be between 2 and 10, inclusive.");
                System.out.print("Enter a number to use for factorial:");
                userInput = input.nextInt();
            }
        }
        while(userInput < 2 || userInput > 10);
        
        // While number is greater than or equal to 2 and less than or equal to 10 then it will
        // print that number of spaces.
        String spaces = "";
        while(userInput >= 2 && userInput <= 10){
            for(int i=0; i<userInput; i++){
                spaces+= " ";
            }
            break;  // Stops loop.
        }
        
        System.out.println("Hello" + spaces + "Goodbye");
        System.out.println("________________________________________________________________________");
        System.out.println();   // Empty Line
        
        
        // Section B Header:
        System.out.println("          ------ Section B ------");
        System.out.println("Loop prints powers of 2 between 1 and 50, inclusive.");
        System.out.println("========================================================================");

        // While the power is geting raised answer will print if its less than or eqaul to 50;
        int power = -1;
        double ans = 0;
        while (ans <= 50){
            ans = Math.pow(2, ++power);
            // This if statment is to prevent the last line to print cause when ans = 32
            // it woult print ans=64 in the System.out.println(), but with the if statement it prevents this from happening.
            if(ans <= 50){
                System.out.println("2 to the power of " + power + " power = " + (int) ans);
            }
        }
        
        System.out.println("________________________________________________________________________");
        System.out.println();   // Empty Line

        
        // Section C Header:
        System.out.println("          ------ Section C ------");
        System.out.println("User enters number (n): must be multiple of 3, between 3 and 24.");
        System.out.println("Loop prints values n->0, separated by tabs, by 3's.");
        System.out.println("========================================================================");
        
        // Input for section C:
        // Askes user to enter a multiple of 3.
        System.out.print("Enter a multiple of 3: ");
        userInput = input.nextInt();
        // If the number does not have a remainder of 0, is less than 3, or greater
        // than 24 then it will print out an error message and ask the user to try again.
        do{
            if((userInput < 3 || userInput > 24) || userInput % 3 != 0){
                System.out.print("Error: Enter a multiple of 3 between 3 and 24, inclusive.");
                System.out.print("Enter a multiple of 3: ");
                userInput = input.nextInt();
            }
        }
        while((userInput < 3 || userInput > 24) || userInput % 3 != 0);
        
        // When the while statement is false then it will continues on the this for loop.
        // This for loop will then run subtracting 3 from the user input till the number is no longer greater than or equal to 0.
        for(int i=userInput; i >= 0; i-=3){
            System.out.print(i + "   ");
        }
        
        System.out.println();   // Empty Line
        System.out.println("________________________________________________________________________");
        System.out.println();   // Empty Line
        
        
        // Section D Header:
        System.out.println("          ------ Section D ------");
        System.out.println("Loop shows range of dinner prices from $10.00 -> $15.00");
        System.out.println("and using .75 increments, calculates 20% tip, total, and prints a table.");
        System.out.println("========================================================================");
        System.out.println("Dinner Price        20% Tip         Total");
        
        // While dinnerPrice is less than or equal to 15 then dinner plan will increment by 0.75 after each loop cycle is completed.
        for(double dinnerPrice = 10; dinnerPrice <= 15; dinnerPrice += .75){
            //Find the what the 20% tip is for the dinner price.
            double tip = dinnerPrice * 0.20;
            
            // Use the adds tip back to the dinnerPrice to get the total amount spent.
            double total = dinnerPrice + tip;
            
            // Prints the line while setting the decimal point to the 2nd decimal place.
            //Using String.format() to get the second decimal place.
            System.out.println("$" + String.format("%.2f", dinnerPrice) + "              $" + String.format("%.2f", tip) + "           $" + String.format("%.2f", total));
        }
        
        System.out.println("________________________________________________________________________");
        System.out.println();   // Empty Line
        
        
        // Section E Header:
        System.out.println("          ------ Section E ------");
        System.out.println("2 different sums will be calculated.");
        System.out.println("Loop: User enters unknown number of integer numbers.");
        System.out.println("First value will be added to sum#1, second value added to sum #2.");
        System.out.println("Actions will be repeated as long as user enters positive numbers.");
        System.out.println("========================================================================");
        
        // Input for Section E:
        int sum1 = 0, sum2 = 0, counter = 0;
        System.out.print("Enter a number to add to first sum: ");
        userInput = input.nextInt();
        
        
        // While the inputed number is greater than 0 (non-negative).
        while(userInput > 0){
            // Counter is used to rotate on what sum we are adding the number to.
            counter++;  // Each time counter increments it will choose what sum it should be mutiplied to.
            
            // If the sum is odd it will add the userInput to the first sum
            if(counter % 2 == 1){
                sum1+= userInput;
                
                System.out.print("Enter a number to add to second sum: ");
                userInput = input.nextInt();
            }
            // else if even it will add it to second sum.
            else{
                sum2 += userInput;
                
                System.out.print("Enter a number to add to first sum: ");
                userInput = input.nextInt();
            }
        }
        
        // Prints out what the sum the sum is from the if statement.
        System.out.println("First sum: " + sum1 + "       Second sum: " + sum2);
    }
}

