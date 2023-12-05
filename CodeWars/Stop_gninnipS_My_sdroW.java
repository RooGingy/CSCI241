
/**
 * Write a description of class Stop_gninnipS_My_sdroW here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.*;
import java.io.*;
import java.util.*;

public class Stop_gninnipS_My_sdroW
{
    public static void main(String[] args){
        final String sentence = "This is another test";
        String revesedSentence = "";
        
        String[] words = sentence.split(" ");

        for(int i=0; i<words.length; i++){
            if(words[i].length()>5){
                StringBuffer str = new StringBuffer(words[i]);
                str.reverse();
                words[i] = str.toString();
            }
        }
        
        for(int i=0; i<words.length; i++){
            revesedSentence+=words[i]+" ";
        }
        
        System.out.println(revesedSentence);
    }
}