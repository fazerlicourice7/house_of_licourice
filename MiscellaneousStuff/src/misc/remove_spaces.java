/*
 * WAP to take a string input from the user and remove all the spaces from
   the input and print the final result.
 */
package misc;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author fazer
 */
public class remove_spaces {
    BufferedReader hi = new BufferedReader (new InputStreamReader (System.in));
    char Input;
    ArrayList Result = new ArrayList();
    String result;
    private void remove () throws IOException { 
        System.out.println("Enter a sentence.");
        Input = ' ';
        while (Input != '\n') {
            Input = (char) hi.read();
            if (Input != ' ') {
                Result.add(Input);
            }
        }
        result = "";
        int size = Result.size();
        for (int i = 0; i < size; i++) {
            result = result + Result.get(i);
        }
        System.out.println (result);
    }
    public static void main (String args[]) throws IOException {
        remove_spaces obj = new remove_spaces();
        obj.remove();
    }
}
