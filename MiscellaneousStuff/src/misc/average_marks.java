/*
 * Finds the average percentage of all your marks in all subjects. 
 */
package misc;
import java.io.*;
/**
 *@author fazer
 */
public class average_marks {
    BufferedReader hi = new BufferedReader (new InputStreamReader (System.in));
    String MATH, LIT, COMP, CHEM, PHY, BIO, HIST, GEO, LANG, FRENCH;
    int math, lit, comp, chem, phy, bio, hist, geo, lang, french, average;
    private void find_average()throws IOException {
        System.out.println("Enter your marks ( /100 ) in: ");
        System.out.println("Math:");
        MATH = hi.readLine();
        math = Integer.parseInt(MATH);
        System.out.println("Physics:"); 
        PHY  = hi.readLine();
        phy = Integer.parseInt(PHY);
        System.out.println("Chemistry:");
        CHEM = hi.readLine();
        chem = Integer.parseInt(CHEM);
        System.out.println("Biology:");
        BIO = hi.readLine();
        bio = Integer.parseInt(BIO);
        System.out.println("Computer / Economics / Art :");
        COMP = hi.readLine();
        comp = Integer.parseInt(COMP);
        System.out.println("History:");
        HIST = hi.readLine();
        hist = Integer.parseInt(HIST);
        System.out.println("Geography:");
        GEO = hi.readLine();
        geo = Integer.parseInt(GEO);
        System.out.println("English Literature:");
        LIT = hi.readLine();
        lit = Integer.parseInt(LIT);
        System.out.println("English Language (Grammar) :");
        LANG = hi.readLine();
        lang = Integer.parseInt(LANG);
        System.out.println("French:");
        FRENCH = hi.readLine();
        french = Integer.parseInt(FRENCH);
        
        average = (math + phy + chem + bio + comp + hist + geo + french + lit + lang) / 10;
        System.out.println("You bagged an average of " +average +"%");
    }   
    public static void main (String args[]) throws IOException {
        average_marks obj = new average_marks();
        obj.find_average();
    }
}
