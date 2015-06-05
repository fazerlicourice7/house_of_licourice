/*
 * this program finds the shortest word in a given (string) input. 
 */
package misc;
import java.io.*;
import java.util.ArrayList;
/**
 * @author fazerlicourice
 */
public class shortest_word {
    BufferedReader hi = new BufferedReader (new InputStreamReader (System.in));
    char input;
    int l1, l2, no = 0;
    String shortest = "";
    ArrayList word = new ArrayList();
    private void word () throws IOException {
        System.out.println("Enter a sentence. this program will find the shortest word in your input and display it to you.");
        
        while (input != '.'){  // continues until input reaches end of line   '/n' PARAMETER IS INCORRECT. FIND CORRECT PARAMETER
            input = (char) hi.read();
            while(input != ' ' && input != '.'){
                if (input != ' '){
                    word.add (input); // adds single characters to the array list, stops at the end of each word
                }  
                input = (char) hi.read(); // input is read one character at a time
            }
            
            if (no == 0) {
                for (int i = 0; i < word.size(); i++){          
                        shortest += word.get(i);
                }
            }
            
            l1= word.size();  // length of the current word
            l2 = shortest.length(); // length of the current shortest word
            if(l1 < l2) {  // determines whether or not the current word is shorter than the previous shortest.
                shortest = "";
                for (int i = 0; i < word.size(); i++){          
                        shortest += word.get(i);
                }
            }
            word.clear(); // erases the current word 
            no++; // increased for every word in the input
        }
        System.out.println("There are " +no +" words in your input and '" +shortest +"' is the shortest out of all of them.");
    }
    public static void main (String args[]) throws IOException {
        shortest_word obj = new shortest_word();
        obj.word();
    }
}
