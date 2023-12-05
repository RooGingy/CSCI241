/**
* Name: AUSTIN MOSER (moser)
* Course: CSCI 241 - Computer Science I
* Section: 001
* Assignment: 3
*
* Project/Class Description:
* This program will calculate mileage for an electric car.
* It prompts the user for input needed
* and then calculates trip mileage details.
* Finally, it prints a report of this information.
*
* Known bugs:
* rounding to 2nd and third decimal place
* 
*/

import java.util.*;

public class Milage
{
    public static void main(String[] args)
    {
        // Constant Variables;
        final double KILOMERTERS_PER_MILE = 1.609344;
        final int WATTS_PER_KILOWATT = 1000;
        final int MINUTES_PER_HOUR = 60;
        
        // Explains to the user what the program is suppose to do.
        System.out.println("This program will calculate mileage for an electric car.");
        System.out.println("It prompts the user for input needed");
        System.out.println("and then calculates trip mileage details.");
        System.out.println("Finally, it prints a report of this information.");
        System.out.println();   // Empty line.

        
        // Scanner to get user input.
        Scanner input = new Scanner(System.in);
        
        // Input for name.
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        // Input for mileage at start of trip.
        System.out.print("Enter mileage reading at start of trip: ");
        int mileageStart = input.nextInt();
        
        // Input for mileage at end of trip.
        System.out.print("Enter mileage reading at end of trip: ");
        int mileageEnd = input.nextInt();
        
        // Input for total hours long that the trip was.
        System.out.print("Enter total hours used for trip: ");
        double time = input.nextDouble();
        time = Math.round(time*100.0)/100.0;    // Rounds to the second decimal place.
        
        // Input for kilowatts per 100 miles.
        System.out.print("Enter miles-per-watt for this car: ");
        int milesPerWatt = input.nextInt();
        
        // Calculates the distance in miles.
        double totalMilage = mileageEnd - mileageStart;
        
        // Converts miles to kilometers.
        double totalKilometers = totalMilage * KILOMERTERS_PER_MILE;
        totalKilometers = Math.round(totalKilometers*100.0)/100.0;    // Rounds to the second decimal place.
        
        // Calculates the total time the trip took in minute.
        double totalMin = time * MINUTES_PER_HOUR;
        
        // Calculate the total kilowatts consumed.
        double electricityConsumed = totalMilage / milesPerWatt;
        electricityConsumed = electricityConsumed / WATTS_PER_KILOWATT;
        
        //Calculate the the millage kilowatts per kilometer.
        double kilowattsPerKilometer = ((WATTS_PER_KILOWATT / totalKilometers) * electricityConsumed) * 100.0E-5;
        
        // Calculates average speed in miles per hour.
        double milesPerHour = totalMilage / time;
        milesPerHour = Math.round(milesPerHour*100.0)/100.0;    // Rounds to the second decimal place.

        // Calculates the average speed in kelometers per hour.
        double kilometersPerMin = totalKilometers / totalMin;
        kilometersPerMin = Math.round(kilometersPerMin*1000.0)/1000.0;    // Rounds to the second decimal place.

        
        // Output Header:
        System.out.println();   // Empty line.
        System.out.println("------------------------------------------------------");
        System.out.println("Welcome to the Mileage Calculator of the 21st Century!");
        System.out.println("------------------------------------------------------");
        System.out.println("Electric Car Trip Results for " + name);
        System.out.println();   // Empty line.
        
        // Output for trip distance and trip time.
        System.out.println("Trip distance: " + totalMilage + " miles, " + totalKilometers + " kilometers");
        System.out.println("Trip time: " + time + " hours (" + totalMin + " minutes)");
        System.out.println();   // Empty line.
        
        // Output for  electicity consumed and kilowatts per kilometer.
        System.out.println("Electricity consumed in kilowatts: " + electricityConsumed);
        System.out.println("Mileage in kilowatts per kilometer: " + kilowattsPerKilometer);
        System.out.println();   // Empty line.
        
        // Output for avearge speed in miles per hour and kilometers per hour.
        System.out.println("Average speed in miles per hour: " + milesPerHour);
        System.out.println("Average speed in kilometers per minute: " + kilometersPerMin);
    }
}
