package misc;

/**
 * Write a program to generate a phrase of witty words.(using pre defined sets of words)
 */
import java.io.*;
import java.util.ArrayList;
public class phrase_generator{ 
    ArrayList one = new ArrayList(7) , two = new ArrayList(7) , three = new ArrayList(7); 
    String phrase = "";
    private void generator() throws IOException {
        one.add("witty");
        one.add("overpowered");
        one.add("fun-loving");
        one.add("carefree");
        one.add("crack-headed");
        one.add("water-proof");
        one.add("nerdy");
        
        two.add("hot");
        two.add("colorful");
        two.add("pissing-off");
        two.add("splendid");
        two.add("black");
        two.add("booger-faced");
        two.add("intricate");
        
        three.add("piece of shit");
        three.add("braniac");
        three.add("blob");
        three.add("beauty");
        three.add("bookworm");
        three.add("dipshit");
        three.add("fat-ass");
        
        int v1 = (int) (Math.random() * 6);
        int v2 = (int) (Math.random() * 6);
        int v3 = (int) (Math.random() * 6);
        phrase += one.get(v1) +", " + two.get(v2) + " " + three.get(v3);
        System.out.println("You are a " +phrase);
    }
    public static void main(String args[]) throws IOException {
        phrase_generator obj = new phrase_generator();
        obj.generator();
    }
}