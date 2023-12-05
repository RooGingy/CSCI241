
/**
* Name: AUSTIN MOSER (moser)
* Course: CSCI 241 - Computer Science I
* Section: 001 or 002
* Assignment: 1
*
* Project/Class Description:
*   This class emulates a Postal Teller window found in a US Post Office.
*   The custiome gives the person an amount of money, from which they
*   receive (as many as possible) first-class mail stamps, then a postcard 
*   stamp (if there is more than a postcard stamp amount left), and all
*   remaining money goes into penny stamps.
*   
* Known bugs:
*   None
*/

import java.util.*; //imports all of javas utility package.

public class PostalTeller
{
    public static final double FIRST_CLASS_STAMP_PRICE = 0.63;  // The current cost of a first class stamp.
    public static final double POSTCARD_STAMP_PRICE = 0.45; // The current cost of a postcard stamp.
    
    // Instance Variables:
    private double money;   // The amount of money entered.
    
    /**
     * Constructor for PostalTeller
     * It initialized the money for the transaction to zero.
     */
    public PostalTeller()
    {
     money=0.0;
    }
    
    /**
     *  insert() adds money to the counter
     */
    public void insert(double amount)
    {
        money = money + amount;
    }
    
    /**
     * (int) returnFirstClassStamps()
     * This method calculates the maximum number of first claa stamps that
     * can be allocated, and returns that number.
     * It can also calculate the money left for postcard and penny stamps.
     */
    public int returnFirstClassStamps()
    {
        int firstClassStamps = (int)(money / FIRST_CLASS_STAMP_PRICE);
        money = money - firstClassStamps * FIRST_CLASS_STAMP_PRICE;
        return firstClassStamps;
    }
    
    /**
     * (boolean)        returnPostcardStamps()
     * This method will return either one or zero, depending on the amount
     * of money left to buy stamps. You will never have enough left to
     * return more than one postcard stamp.
     */
    public boolean returnPostcardStamps()
    {
        boolean getPostcardStamp = false;
        if(money>=POSTCARD_STAMP_PRICE)
        {
            money = money - POSTCARD_STAMP_PRICE;
            getPostcardStamp = true;
        }
        return getPostcardStamp;
    }
    
    /**
     * (int)        returnPennyStamps()
     * This method uses up all remainding money to return penny stamps.
     */
    public int returnPennyStamps()
    {
        int pennyStamps = (int)Math.round (100 * money);
        money = 0.0;
        return pennyStamps;
    }
    
    /**
     * printResults()
     * prints the stamp counts to standard output
     */
    public static void printStamps(PostalTeller window)
    {
        int firstClassCount = window.returnFirstClassStamps();
        boolean getPostcardStamp = window.returnPostcardStamps();
        int pennyCount = window.returnPennyStamps();
        System.out.print("Fist class stamps: ");
        System.out.println(firstClassCount);
        
        if(!getPostcardStamp)
        {
            System.out.println("You will NOT get a postcard stamp.");
        }
        else
        {
            System.out.print("Get ready for vacation! ");
            System.out.println("You will get a postcard stamp.");
            
        }
        
        System.out.print("Penny Stamp: ");
        System.out.println(pennyCount);
        System.out.println();
    }
    
    /**
     * The main method requests that the customer add money and then returns
     * the appropriate number of first class, postcard and one cent stamps.
     */
    public static void main (String [] args)
    {
        double amount;  // The amount of money entered.
        
        PostalTeller teller1 = new PostalTeller();  // First stamp teller machine that we will use.
        
        Scanner input=new Scanner(System.in);   // The object that lets us read from the keyboard.
        
        // Read the amount of money entered.
        System.out.print("Enter the amount of money for teller1: ");
        amount=input.nextDouble();
        
        // Add the money to the counter and retrieve the stamps.
        teller1.insert(amount);
        printStamps(teller1);
        
        PostalTeller teller2=new PostalTeller();    // Try the other stamp teller machine
        
        // Read the amount of money entered.
        System.out.print("Enter the initial amount of money for teller2: ");
        amount = input.nextDouble();
        
        teller2.insert(amount); // Add the money to the counter.
        
        // Get aditional cash from the customer.
        System.out.print("Add a little extrea for teller2:  ");
        amount = input.nextDouble();
        
        // Add the money to the counter and retrieveve the stamps.
        teller2.insert(amount);
        printStamps(teller2);
    }
}