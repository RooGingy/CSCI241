/**
* Name: AUSTIN MOSER (moser)
* Course: CSCI 241 - Computer Science I
* Section: 001 <-- choose your section
* Assignment: 1
*
* Project/Class Description:
* (summarize Blocks here)
*
* Known bugs:
* none
*/

import java.util.*;

public class Blocks {
    final char ASKI = '*';
    private int dimension;
    
    // Method that asks the users to pick an odd number between 5-11.
    public int getDimension() {
        int d = this.dimension; // sets the reference variable dimension to d.
        
        Scanner input = new Scanner(System.in);
        // While d is outside the range 5-11 and is even it will ask the user enter a number again.
        do{
            System.out.print("Enter a number for what size you want your 2D array to be: ");
            d = input.nextInt();
        }
        while((d < 5 || d > 11) || (d % 2 == 0));
        return d;
    }
    
    // This method is used to print out the stars and spaces.
    public void print(char[][] array2D) {
        dashes(array2D);    // Calls dashes to get the right size for the boarder.
        // The array goes through each element finding if the char of that element is a space or a star.
        for(int r = 0; r < array2D.length; r++){
            for(int c = 0; c < array2D.length; c++){
                //  If the char of that element is a star it will add a space infront of it.
                if(array2D[r][c] == ASKI){
                    System.out.print(" " + ASKI);
                }
                // Else if its a space it will print 2 spaces for the element.
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();   // At the end of each row it will create a new row.
        }
        dashes(array2D);    // Calls dashes to get the right size for the boarder.
    }
    
    // This method is used to reset all elements.
    public void clear(char[][] array2D) {
        // This will go thought all elements.
        for(int r = 0; r < array2D.length; r++){
            for(int c = 0; c < array2D.length; c++){
                array2D[r][c] = ASKI;   // Within each element it will set it to whatever char ASKI is.
            }
        }
    }
    
    public void verticalInside(char[][] array2D) {
        System.out.println("verticalInside()");
        miniBox(array2D);
        /* Calls the method miniBox which looks something like this:
         * 
         * r |c 0 1 2 3 4 5 6
         * 0 | {             }
         * 1 | {  * * * * *  }
         * 2 | {  *       *  }
         * 3 | {  *       *  }
         * 4 | {  *       *  }
         * 5 | {  * * * * *  }
         * 6 | {             }
         */
        
        // Clears out the of the middle part of the box leaving the horizontal lines.
        for(int r = 0; r < array2D.length; r++){
            for(int c = 0; c < array2D.length; c++){
                if(c > 1 && c < array2D.length - 2){
                    array2D[r][c] = ' ';
                }
            }
        }
        print(array2D); // Calls the print method to display it once this method is called.
        
        /* Example Output:
         * r |c 0 1 2 3 4 5 6
         * 0 | {             }
         * 1 | {  *       *  }
         * 2 | {  *       *  }
         * 3 | {  *       *  }
         * 4 | {  *       *  }
         * 5 | {  *       *  }
         * 6 | {             }
         */
    }
    
    public void horizontalInside(char[][] array2D) {
        System.out.println("horizontalInside()");
        miniBox(array2D);
        /* Calls the method miniBox which looks something like this:
         * 
         * r |c 0 1 2 3 4 5 6
         * 0 | {             }
         * 1 | {  * * * * *  }
         * 2 | {  *       *  }
         * 3 | {  *       *  }
         * 4 | {  *       *  }
         * 5 | {  * * * * *  }
         * 6 | {             }
         */
        
        // Clears out the of the middle part of the box leaving the horizontal lines.
        for(int r = 0; r < array2D.length; r++){
            for(int c = 0; c < array2D.length; c++){
                if(r > 1 && r < array2D.length - 2){
                    array2D[r][c] = ' ';
                }
            }
        }
        print(array2D); // Calls the print method to display it once this method is called.
        
        /* Example Output:
         * r |c 0 1 2 3 4 5 6
         * 0 | {             }
         * 1 | {  * * * * *  }
         * 2 | {             }
         * 3 | {             }
         * 4 | {             }
         * 5 | {  * * * * *  }
         * 6 | {             }
         */
    }
    
    public void innerBox(char[][] array2D) {
        System.out.println("innerBox()");
        miniBox(array2D);
        /* Calls the method miniBox which looks something like this:
         * 
         * r |c 0 1 2 3 4 5 6
         * 0 | {             }
         * 1 | {  * * * * *  }
         * 2 | {  *       *  }
         * 3 | {  *       *  }
         * 4 | {  *       *  }
         * 5 | {  * * * * *  }
         * 6 | {             }
         */
        print(array2D); // Calls the print method to display it once this method is called.
    }
    
    public void flag(char[][] array2D) {
        System.out.println("flag()");
        miniBox(array2D);
        /* Calls the method miniBox which looks something like this:
         * 
         * r |c 0 1 2 3 4 5 6
         * 0 | {             }
         * 1 | {  * * * * *  }
         * 2 | {  *       *  }
         * 3 | {  *       *  }
         * 4 | {  *       *  }
         * 5 | {  * * * * *  }
         * 6 | {             }
         */
        // Add the char ASKI in the the corner of each element.
        for(int r = 0; r < array2D.length; r++){
            for(int c = 0; c < array2D.length; c++){
                if((r == 0 && c == 0) || (r == 0 && c == array2D.length - 1)){
                    array2D[r][c] = ASKI;
                }
                else if((r == array2D.length - 1 && c == 0) || (r == array2D.length - 1 && c == array2D.length - 1)){
                    array2D[r][c] = ASKI;
                }
            }
        }
        print(array2D); // Calls the print method to display it once this method is called.
        
        /* Example Output:
         * r |c 0 1 2 3 4 5 6
         * 0 | {*           *}
         * 1 | {  * * * * *  }
         * 2 | {  *       *  }
         * 3 | {  *       *  }
         * 4 | {  *       *  }
         * 5 | {  * * * * *  }
         * 6 | {*           *}
         */
    }
    
    public void leftArrow(char[][] array2D) {
        // For this method I seperated the array into 4 Quadrants.
        clear(array2D); // Clears the array to create a new array design.
        System.out.println("leftArrow()");
        
        // Quadrant 1: (Top Right Corner)
        // Creates a rectangle in the top right coner.
        for(int r = 0; r < array2D.length / 2 - 1; r++){
            for(int c = array2D.length / 2 + 1; c < array2D.length; c++){
                array2D[r][c] = ' ';
            }
        }
        
        // Quadrant 2: (Top Left Corner)
        quadrant2Triangle(array2D); // Calls the quadrant2Triangle method to get the right triangle in the top left corner.
        
        //Quadrant3: (Bottom Left Corner)
        quadrant3Triangle(array2D); // Calls the quadrant3Triangle method to get the right triangle in the bottom left corner.

        // Quadrant 4: (Bottom Right Corner)
        // Creates a rectangle in the bottom right coner.
        for(int r = (array2D.length / 2) + 2 ; r < array2D.length; r++){
            for(int c = (array2D.length / 2) + 1; c < array2D.length; c++){
                array2D[r][c] = ' ';
            }
        }
        // Calls the print method to display it once this method is called.
        print(array2D); // Calls the print method to display it once this method is called.
        
        /* Example Output:
         * r |c 0 1 2 3 4 5 6
         * 0 | {      *      }
         * 1 | {    * *      }
         * 2 | {  * * * * * *}
         * 3 | {* * * * * * *}
         * 4 | {  * * * * * *}
         * 5 | {    * *      }
         * 6 | {      *      }
         */
    }
    
    public void rightArrow(char[][] array2D) {
        // For this method I seperated the array into 4 Quadrants.
        clear(array2D); // Clears the array to create a new array design.
        System.out.println("rightArrow()");
        
        // Quadrant 1: (Top Right Corner)
        quadrant1Triangle(array2D); // Calls the quadrant1Triangle method to get the right triangle in the top right corner.
        
        // Quadrant 2:
        for(int r = 0; r < (array2D.length / 2) - 1; r++){
            for(int c = 0; c < array2D.length / 2; c++){
                array2D[r][c] = ' ';
            }
        }
        
        // Quadrant 3:
        for(int r = (array2D.length / 2) + 2; r < array2D.length; r++){
            for(int c = 0; c < array2D.length / 2; c++){
                array2D[r][c] = ' ';
            }
        }
        
        // Quadrant 4: (Bottom Right Corner)
        quadrant4Triangle(array2D); // Calls the quadrant4Triangle method to get the right triangle in the bottom right corner.
        print(array2D); // Calls the print method to display it once this method is called.
        
        /* Example Output:
         * r |c 0 1 2 3 4 5 6
         * 0 | {      *      }
         * 1 | {      * *    }
         * 2 | {* * * * * *  }
         * 3 | {* * * * * * *}
         * 4 | {* * * * * *  }
         * 5 | {      * *    }
         * 6 | {      *      }
         */
    }
    
    public void diamond(char [][] array2D){
        // For this method I seperated the array into 4 Quadrants.
        clear(array2D); // Clears the array to create a new array design.
        System.out.println("diamond()");
        
        // Quadrant 1: (Top Right Corner)
        quadrant1Triangle(array2D); // Calls the quadrant1Triangle method to get the right triangle in the top right corner.
        
        // Quadrant 2: (Top Left Corner)
        quadrant2Triangle(array2D); // Calls the quadrant2Triangle method to get the right triangle in the top left corner.
        
        //Quadrant3: (Bottom Left Corner)
        quadrant3Triangle(array2D); // Calls the quadrant3Triangle method to get the right triangle in the bottom left corner.

        // Quadrant 4: (Bottom Right Corner)
        quadrant4Triangle(array2D); // Calls the quadrant4Triangle method to get the right triangle in the bottom right corner.
        
        print(array2D); // Calls the print method to display it once this method is called.
        
        /* Example Output:
         * r |c 0 1 2 3 4 5 6
         * 0 | {      *      }
         * 1 | {    * * *    }
         * 2 | {  * * * * *  }
         * 3 | {* * * * * * *}
         * 4 | {  * * * * *  }
         * 5 | {    * * *    }
         * 6 | {      *      }
         */
    }
    
    // Additional Methods;
    public void quadrant1Triangle (char[][] array2D) {
        // Creates a right trinalge in the top right corn and sets it as a space
        for(int r = (array2D.length / 2) - 1; r >= 0; r--) {
            for(int c = r + (array2D.length / 2) + 1; c < array2D.length; c++) {
                array2D[r][c] = ' ';
            }
        }
        
        /* Example Output:
         * r |c 0 1 2 3 4 5 6
         * 0 | {        * * *}
         * 1 | {          * *}
         * 2 | {            *}
         * 3 | {             }
         * 4 | {             }
         * 5 | {             }
         * 6 | {             }
         */
    }
    
    public void quadrant2Triangle (char[][] array2D){
        // Creates a right trinalge in the top left corn and sets it as a space
        for(int r = 0; r < array2D.length; r++){
            for(int c = 0; c < (array2D.length / 2) - r; c++){
                array2D[r][c] = ' ';
            }
        }
        
        /* Example Output:
         * r |c 0 1 2 3 4 5 6
         * 0 | {* * *        }
         * 1 | {* *          }
         * 2 | {*            }
         * 3 | {             }
         * 4 | {             }
         * 5 | {             }
         * 6 | {             }
         */
    }
    
    public void quadrant3Triangle (char[][] array2D) {
        // Creates a right trinalge in the bottom left corn and sets it as a space
        for(int r = array2D.length / 2 + 1; r < array2D.length; r++){
            for(int c = 0; c < r - (array2D.length / 2); c++){
                array2D[r][c] = ' ';
            }
        }
        
        /* Example Output:
         * r |c 0 1 2 3 4 5 6
         * 0 | {             }
         * 1 | {             }
         * 2 | {             }
         * 3 | {             }
         * 4 | {*            }
         * 5 | {* *          }
         * 6 | {* * *        }
         */
    }
    
    public void quadrant4Triangle (char[][] array2D) {
        // Creates a right trinalge in the bottom right corn and sets it as a space.
        int i = 1;
        for(int r = (array2D.length / 2) + 1; r < array2D.length; r++){
            for(int c = array2D.length - 1; c >= array2D.length - i; c--){
                array2D[r][c] = ' ';
            }
            i++;
        }
        
        /* Example Output:
         * r |c 0 1 2 3 4 5 6
         * 0 | {             }
         * 1 | {             }
         * 2 | {             }
         * 3 | {             }
         * 4 | {            *}
         * 5 | {          * *}
         * 6 | {        * * *}
         */
    }
    
    public void dashes(char[][] array2D) {
        // Finds how long the array is and doubles it.
        for(int i = 0; i <= array2D.length * 2; i++) {
            System.out.print("-");   // Prints out a dash
        }
        System.out.println();   // Starts a new line after the dahses print.
    }
    
    public void miniBox(char[][] array2D) {
        clear(array2D); // Clears the array to create a new array design.
        
        for(int r = 0; r < array2D.length; r++) {
            for(int c = 0; c < array2D.length; c++) {
                // Takes all the edge elements of the array and sets it to a space.
                if(r == 0 || r == array2D.length - 1){
                    array2D[r][c] = ' ';
                }
                // Takes all the edge elements of the array and sets it to a space.
                else if(c == 0 || c == array2D.length - 1){
                    array2D[r][c] = ' ';
                }
                // Takes all the middle elements of the array and sets it to a space.
                else if((r > 1 && r < array2D.length - 2) && (c > 1 && c < array2D.length - 2)) {
                    array2D[r][c] = ' ';
                }
            }
        }
        
        /* Example Output:
         * r |c 0 1 2 3 4 5 6
         * 0 | {             }
         * 1 | {  * * * * *  }
         * 2 | {  *       *  }
         * 3 | {  *       *  }
         * 4 | {  *       *  }
         * 5 | {  * * * * *  }
         * 6 | {             }
         */
    }
    
    public static void main(String[] args) {
        // Creates an object called Block (this will let use access getDimension()).
        Blocks block = new Blocks();
        
        // We call the object to get the demention of the 2D Array and store it to a varable arrayDimension.
        int arrayDimension = block.getDimension();
        // We then set create a new 2D Array using the varable arrayDimension to set the 2D Arrays length.
        char[][] blockArray = new char[arrayDimension][arrayDimension];
        
        // Calls the object block and prints out each of the block desings created.
        block.verticalInside(blockArray);
        block.horizontalInside(blockArray);
        block.innerBox(blockArray);
        block.flag(blockArray);
        block.leftArrow(blockArray);
        block.rightArrow(blockArray);
        block.diamond(blockArray);
    }
}
