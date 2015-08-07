package anagramMaker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 18balanagav
 */
public class anagram_Maker {

    BufferedReader READ = new BufferedReader(new InputStreamReader(System.in));
    FileReader readFile;
    BufferedReader READFILE = new BufferedReader(readFile);

    public anagram_Maker() throws FileNotFoundException {
        this.readFile = new FileReader("dictionary.txt");
    }

    public char[] dissassemble() throws IOException {
        String input = READ.readLine();
        char[] letters = input.toCharArray();
        return letters;
    }

    public void checks_dictionary(char[] letters) throws IOException {
        String word = new String();
        while (word != null) {
            word = READFILE.readLine();
           
        }
    }

    public static void main(String args[]) throws IOException {
        anagram_Maker methodCaller = new anagram_Maker();
        char[] letters = methodCaller.dissassemble();
        methodCaller.checks_dictionary(letters);
    }
}
