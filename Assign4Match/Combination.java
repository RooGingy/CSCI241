
/**
* Name: AUSTIN MOSER (moser)
* Course: CSCI 241 - Computer Science I
* Assignment: 4
*
* Project/Class Description:
* A random generater generates a 6-digit number between 0-999999. The program then seperates 
* the generated 6-digit number into 3 2-digit numbers lock combinations. The user is then suppose
* to guess the 3 2-digit combinations. If the user gets it right it unlocks. With that it displays
* additional output such as how my duplicates there in the guessed input (the program also splits the
* users guess into 3 2-digit numbers). Other features are to tell the user how many numbers that got
* appear in the combination, or if they got all the numbers but they are out of order. If they user
* didn't get any of the 3 2-digit number corret then the the combination stay locked.
*
* Known bugs:
* None.
*/

import java.util.*;

public class Combination{
    public static void main(String[] args){
        // Create a random generater that picks a number between 0-999999.
        Random rand = new Random();
        
        // The random number is set to lockCombination.
        int lockCombination = rand.nextInt(1000000);  //Use 1000000 cause its set back by 1 number. Cant really eplain why but I just know you need to up it by 1.
        // lockCombination = 123456;   //use this as a test number.
        
        
        // Seperate the lock combination into 3 parts (first-middle-last)and print it out.
        // Seperates lockCombination into 3 parts (first-middle-last):
        int firstLock, middleLock, lastLock, x;
        
        // Seperates the first part of lockCombination.
        firstLock = lockCombination / 10000;
        
        //Removes the first part of lockCombination
        x = lockCombination - (firstLock * 10000);
        
        // Seperates the middle part of lockCombination.
        middleLock = x / 100;
        
        // Seperates the last part of lockCombination.
        lastLock = x - (middleLock * 100);
        
        // Prints the combination out so we can test the program.
        System.out.println("Combination numbers are: " + firstLock + "-" + middleLock + "-" + lastLock);
    
        
        // Asks user to enter a combination guess.
        System.out.print("Enter your combination guess (six digits): ");
        
        // Input Scanner so the users could guess the combination.
        Scanner input = new Scanner(System.in);
        int enteredCombination = input.nextInt();
        
        
        // Seperate the entered combination into 3 parts (first-middle-last).
        // Seperates enteredCombination in to 3 parts (first-middle-last).
        int firstEntered, middleEntered, lastEntered;
        x = 0; // Resets x back to 0 just for safty reasons.
        
        // Seperates the first part of enteredCombination.
        firstEntered = enteredCombination / 10000;
        
        // Removes the fist part of enteredCombination.
        x = enteredCombination - (firstEntered * 10000);

        // Seperates the middle part of enteredCombination.
        middleEntered = x / 100;
        
        // Seperates the last part of enteredCombination.
        lastEntered = x - (middleEntered * 100);
        
        
        /*
         * abc and xyz will be uses as an example to explain what this If-Else-If statement is
         * doing. For all the If-Else-If statements Shown below
         * 
         * abc == User Input
         * xyz == Generated Number
         * 
         * NOTE: abc are seperated into 3 thier individual letter parts 
         *       to repersent the 3 2-digit numbers (same goes for xyz).
         * 
         *
         * 3 duplicates:
         * If 'a' equal 'b' and 'c' then there is 3 duplicate numbers, because a=b and a=c, 
         * and if a=b and a=c then both b and c is the same the same as 'a', and since they
         * are the same value of at it means there are 3 duplicates. With this logic I can
         * make other simular versions of these.
         */
        if ((firstEntered == middleEntered) && (firstEntered == lastEntered)){
            System.out.println("Guess contains three duplicate numbers.");
        }
        else if ((middleEntered == firstEntered) && (middleEntered == lastEntered)){
            System.out.println("Guess contains three duplicate numbers.");
        }
        else if ((lastEntered == firstEntered) && (lastEntered == middleEntered)){
            System.out.println("Guess contains three duplicate numbers.");
        }
        
        /*
         * 2 duplicates:
         * What I did for the 2 duplicats is if 'a' equals 'b' or 'c', then there is 2 duplucate
         * numbers because a=b or a=2 and if a = b or a = c then both b or c equals the same  as
         * 'a'. To prevent the wrong output we set the 3 duplicates if statements on top that way if
         * 'b' and 'c' does equal 'a' then it will print 3 duplicates first so the 2 duplicates doesn't
         * print.
         */
        else if ((firstEntered == middleEntered) || (firstEntered == lastEntered)){
            System.out.println("Two numbers in guess are duplicates of each other.");
        }
        else if ((middleEntered == firstEntered) || (middleEntered == lastEntered)){
            System.out.println("Two numbers in guess are duplicates of each other.");
        }
        else if ((lastEntered == firstEntered) || (lastEntered == middleEntered)){
            System.out.println("Two numbers in guess are duplicates of each other.");
        }
        
        // Same thing from the enteredLock is applied to the lockCombination on how many duplicates there are.
        if ((firstLock == middleLock) && (firstLock == lastLock)){
            System.out.println("Combination contains three duplicate numbers.");
        }
        else if ((middleLock == firstLock) && (middleLock == lastLock)){
            System.out.println("Combination contains three duplicate numbers.");
        }
        else if ((lastLock == firstLock) && (lastLock == middleLock)){
            System.out.println("Combination contains three duplicate numbers.");
        }
        else if ((firstLock == middleLock) || (firstLock == lastLock)){
            System.out.println("Two numbers in combination are duplicates of each other.");
        }
        else if ((middleLock == firstLock) || (middleLock == lastLock)){
            System.out.println("Two numbers in combination are duplicates of each other.");
        }
        else if ((lastLock == firstLock) || (lastLock == middleLock)){
            System.out.println("Two numbers in combination are duplicates of each other.");
        }
        
        
        // If everything matches then lock opens. (a=x, b=y, c=z)
        if ((firstEntered == firstLock && middleEntered == middleLock) && (firstEntered == firstLock && lastEntered == lastLock)){
            System.out.println("Exact match: Lock is open!");
        }
        
        /* Out of sequence:
         * To tell if the letter are out of squence i used a generater to get me all possible ways abc can be rearanged.
         * it only showed me 6 ways (one being the one that matches the combination). I used that to give me a head start
         * of all the possible out comes. I then used that and have it equal its opposite parts. With a few equaling one
         * locked parts. For an example if a=x, b=z and c=y. Then you have something like this a=z, b=x, and c=y where
         * each part doesn't eqaul its corresponding lock part, and of course I made different variations of these.
         */
        else if ((firstEntered == firstLock && lastEntered == middleLock) && (firstEntered == firstLock && middleEntered == lastLock)){
            System.out.println("All numbers match but are out of sequence.");
        }
        else if ((middleEntered == firstLock && firstEntered == middleLock) && (middleEntered == firstLock && lastEntered == lastLock)){
            System.out.println("All numbers match but are out of sequence.");
        }
        else if ((middleEntered == firstLock && lastEntered == middleLock) && (middleEntered == firstLock && firstEntered == lastLock)){
            System.out.println("All numbers match but are out of sequence.");
        }
        else if ((lastEntered == firstLock && firstEntered == middleLock) && (lastEntered == firstLock && middleEntered == lastLock)){
            System.out.println("All numbers match but are out of sequence.");
        }
        else if ((lastEntered == firstLock && middleEntered == middleLock) && (lastEntered == firstLock && firstEntered == lastLock)){
            System.out.println("All numbers match but are out of sequence.");
        }
        
        
        /*
         * This is kind of the same a duplicates just adding xyz in a replace ment of a few variables all I did was add anther 
         * expretion in an if statement so and compared the 2 with an or opperate that way there are less else if statements. 
         * If a=x ,b=y, or b=z. If 'a' equal 'x' then 'b' will equal 'y' or 'z'.
         */
        // Different senerios of the user guessing 2 of the combination numbers that appears in the combination.
        else if ((firstEntered == firstLock && middleEntered == middleLock) || (firstEntered == firstLock && middleEntered == lastLock)){
            System.out.println("Two numbers guessed appear in the combination");
        }
        else if ((firstEntered == firstLock && lastEntered == middleLock) || (firstEntered == firstLock && lastEntered == lastLock)){
            System.out.println("Two numbers guessed appear in the combination");
        }
        else if ((middleEntered == firstLock && firstEntered == middleLock) || (middleEntered == firstLock && firstEntered == lastLock)){
            System.out.println("Two numbers guessed appear in the combination");
        }
        else if ((middleEntered == firstLock && lastEntered == middleLock) || (middleEntered == firstLock && lastEntered == lastLock)){
            System.out.println("Two numbers guessed appear in the combination");
        }
        else if ((lastEntered == firstLock && firstEntered == middleLock) || (lastEntered == firstLock && firstEntered == lastLock)){
            System.out.println("Two numbers guessed appear in the combination");
        }
        else if((lastEntered == firstLock && middleEntered == middleLock) || (lastEntered == firstLock && middleEntered == lastLock)){
            System.out.println("Two numbers guessed appear in the combination");
        }
        
        
        /*
         * 1 number appears in combination:
         * What I did was make different variations of a=x, b!=y, c!=z. I then found out 'a' can equal any of
         * the values of xyz so i created the different variations using the same method. For the majority of
         * it I sqwaped 'y' and z from b!=y and c!=z to get b!=z and c!=y after that I set 'a' equal to 'y'
         * and then reset what 'b' and 'c' back to what it was and repeated that method.
         */
        else if ((firstEntered == firstLock && middleEntered != middleLock) && (firstEntered == firstLock && lastEntered != lastLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((firstEntered == firstLock && lastEntered != middleLock) && (firstEntered == firstLock && middleEntered != lastLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((firstEntered == middleLock && middleEntered != firstLock) && (firstEntered == middleLock && lastEntered != lastLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((firstEntered == middleLock && lastEntered != lastLock) && (firstEntered == middleLock && middleEntered != firstLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((firstEntered == lastLock && middleEntered != middleLock) && (firstEntered == lastLock && lastEntered != firstLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((firstEntered == lastLock && lastEntered != firstLock) && (firstEntered == lastLock && middleEntered != middleLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((middleEntered == firstLock && firstEntered != middleLock) && (middleEntered == firstLock && lastEntered != lastLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((middleEntered == firstLock && lastEntered != middleLock) && (middleEntered == firstLock && firstEntered != lastLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((middleEntered == middleLock && firstEntered != firstLock) && (middleEntered == middleLock && lastEntered != lastLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((middleEntered == middleLock && lastEntered != lastLock) && (middleEntered == middleLock && firstEntered != firstLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((middleEntered == lastLock && firstEntered != middleLock) && (middleEntered == lastLock && lastEntered != firstLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((middleEntered == lastLock && lastEntered != firstLock) && (middleEntered == lastLock && firstEntered != middleLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((lastEntered == firstLock && firstEntered != middleLock) && (lastEntered == firstLock && middleEntered != lastLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((lastEntered == firstLock && middleEntered != middleLock) && (lastEntered == firstLock && firstEntered != lastLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((lastEntered == middleLock && firstEntered != firstLock) && (lastEntered == middleLock && middleEntered != lastLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((lastEntered == middleLock && middleEntered != lastLock) && (lastEntered == middleLock && firstEntered != firstLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((lastEntered == lastLock && firstEntered != middleLock) && (lastEntered == lastLock && middleEntered != firstLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        else if ((lastEntered == lastLock && middleEntered != firstLock) && (lastEntered == lastLock && firstEntered != middleLock)){
            System.out.println("One number in the guess appears in the combination.");
        }
        
        // If nothing works then it will tell the user that it's not their locker.
        else{
            System.out.println("Sorry, no match. Not your locker!");    //This works for if a letter was typed in the input.
        }
    }
}

/*
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠴⠤⠤⠴⠄⡄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣠⠄⠒⠉⠀⠀⠀⠀⠀⠀⠀⠀⠁⠃⠆⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⢀⡜⠁⠀⠀⠀⢠⡄⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠑⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⢈⠁⠀⠀⠠⣿⠿⡟⣀⡹⠆⡿⣃⣰⣆⣤⣀⠀⠀⠹⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣼⠀⠀⢀⣀⣀⣀⣀⡈⠁⠙⠁⠘⠃⠡⠽⡵⢚⠱⠂⠛⠀⠀⠀⠀Look at all the copy and pasted code.
⠀⠀⠀⠀⠀⡆⠀⠀⠀⠀⢐⣢⣤⣵⡄⢀⠀⢀⢈⣉⠉⠉⠒⠤⠀⠿⠀⠀⠀⠀Isn't it awesome to be so confused.
⠀⠀⠀⠀⠘⡇⠀⠀⠀⠀⠀⠉⠉⠁⠁⠈⠀⠸⢖⣿⣿⣷⠀⠀⢰⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⢀⠃⠀⡄⠀⠈⠉⠀⠀⠀⢴⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢈⣇⠀⠀⠀⠀⠀⠀⠀⢰⠉⠀⠀⠱⠀⠀⠀⠀⠀⢠⡄⠀⠀⠀⠀⠀⣀⠔⠒⢒⡩⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⣴⣿⣤⢀⠀⠀⠀⠀⠀⠈⠓⠒⠢⠔⠀⠀⠀⠀⠀⣶⠤⠄⠒⠒⠉⠁⠀⠀⠀⢸⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⡄⠤⠒⠈⠈⣿⣿⣽⣦⠀⢀⢀⠰⢰⣀⣲⣿⡐⣤⠀⠀⢠⡾⠃⠀⠀⠀⠀⠀⠀⠀⣀⡄⣠⣵⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠘⠏⢿⣿⡁⢐⠶⠈⣰⣿⣿⣿⣿⣷⢈⣣⢰⡞⠀⠀⠀⠀⠀⠀⢀⡴⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠈⢿⣿⣍⠀⠀⠸⣿⣿⣿⣿⠃⢈⣿⡎⠁⠀⠀⠀⠀⣠⠞⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠈⢙⣿⣆⠀⠀⠈⠛⠛⢋⢰⡼⠁⠁⠀⠀⠀⢀⠔⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠚⣷⣧⣷⣤⡶⠎⠛⠁⠀⠀⠀⢀⡤⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠈⠁⠀⠀⠀⠀⠀⠠⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
 */