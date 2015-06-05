/*
 * Takes a String input from the user and removes the first and last character. 
 * eg. hello > ell
 */
package misc;
import java.io.*;
import java.util.ArrayList;
/**
 * @author fazer
 */
public class first_last {
   BufferedReader hi = new BufferedReader (new InputStreamReader (System.in)); 
   String result = "";   
   ArrayList input = new ArrayList();
   private void start() throws IOException {
       System.out.println("Enter a word.");
       while( (char)hi.read() != ' ') {
           input.add((char) hi.read());
       }
       for (int i = 1; i < (input.size()-1); i++) {
       result += input.get(i);
       }
       System.out.println(result);
   }
   public static void main (String args[]) throws IOException {
       first_last obj = new first_last();
       obj.start();
   }
}
