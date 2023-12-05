/**
* Name: AUSTIN MOSER (moser)
* Course: CSCI 241 - Computer Science I
* Section: 005
* Assignment: 6
*
* Project/Class Description:
* The user will enter a credit card number and it will say if the card it valid or invalid.
*
* Known bugs:
* None
*/

import java.util.*;

public class CreditCard {
    public static void main(String [] args) {
        //Lets user enter 3 credit card nummbers, and determines if card if valid or invalid.
        for(int i=0; i<3; i++) {
            // Asks use to eneter a credit card number.
            System.out.print("Enter a credit card number as a long integer: ");
            Scanner input = new Scanner(System.in);
            long creditCardNumber = input.nextLong();
            
            // Uses an If Statement to see if the sum of sumOfOddPlaces and sumOfEvenPlaceDoubled is divisible by 10.
            // If it is then the card is valid if not then its invalid.
            if((sumOfEvensDoubled(creditCardNumber) + sumOfOddPlaces(creditCardNumber)) % 10 == 0) {
                System.out.println(creditCardNumber + " is a valid number.");
            }
            else {
                System.out.println(creditCardNumber + " is an invalid number.");
            }
            
            // Test if the output of the methods is correct based on example: (Complete)
            //System.out.println(sumOfEvensDoubled(creditCardNumber));
            //System.out.println(sumOfOddPlaces(creditCardNumber));
        }
    }
    
    // This method takes credit cardCardNumber and muptiplies the double of every even placed digit and added it to sum.
    public static int sumOfEvensDoubled(long cardNumber) {
        int counter = 1, sum = 0, product = 0;
        double digit = 0;
        
        // Uses a loop so that if cardNumber doesnt have anymore digits left in it will stop.
        while(cardNumber != 0) {
            digit = cardNumber % 10;    // Pulls the last digit from card number.
            
            // Uses an if statement to that finds all the even placed numbers.
            if(counter % 2 == 0){
                product = (int)(digit * 2);
                
                // Called method shrinkToOneDigit so that if anynumber holds more that one will shirk it to one number.
                // Then that number will be added to sum.
                sum += shrinkToOneDigit(product);
            }
            counter++;  // Up the counter by one to determine the next even placed number.
            cardNumber /= 10;    // Divided the number by 10 to get the next digit.
        }
        return sum; // Returns the sum of all digits to the location that the method was called.
    }
    
    // This method takes the product from sumOfEvensDoubled and makes any number to one digit by adding the digits of that number.
    public static int shrinkToOneDigit(int doubleDigit) {
        int sum = 0;
        double digit = 0;
        
        // Uses a loop so that if doubleDigit doesnt have anymore digits left in it will stop.
        while(doubleDigit != 0){
            digit = doubleDigit % 10;    // Pulls the last digit from card number.
            sum += (int)(digit);    // Adds the last digit of the number to get one singlar digit.
            doubleDigit /= 10;    // Divided the number by 10 to get the next digit.
        }
        return sum; // Returns the sum of all digits to the location that the method was called.
    }
    
    // This method takes credit cardCardNumber and adds every odd placed digit to sum.
    public static int sumOfOddPlaces(long cardNumber) {
        int counter = 1, sum = 0;
        double digit = 0;
        
        // Uses a loop so that if cardNumber doesnt have anymore digits left in it will stop.
        while(cardNumber != 0) {
            digit = cardNumber % 10;    // Pulls the last digit from card number.
            
            // Uses an if statement to that finds all the odd placed numbers.
            if(counter % 2 == 1){
                sum += (int) digit;   // Adds digit to the sum.
            }
            counter++;  // Up the counter by one to determine the next odd placed number.
            cardNumber /= 10;   // Divided the number by 10 to get the next digit.
        }
        return sum; // Returns the sum of all digits to the location that the method was called.
    }
}
    