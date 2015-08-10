package anagramMaker;

import java.io.*;
import java.util.ArrayList;

/**
 * @author 18balanagav
 */
public class anagram_finder {

    static BufferedReader READ = new BufferedReader(new InputStreamReader(System.in));

    //FileReader readFile;
    //BufferedReader READFILE = new BufferedReader(readFile);

    static ArrayList permutations;
    static ArrayList WORDS;
    /*FileReader readFile;
    BufferedReader READFILE = new BufferedReader(readFile);
*/

    /*public anagram_finder() throws FileNotFoundException {
        this.readFile = new FileReader("lowercase100k.txt");
    }*/

    public static void main(String args[]) throws IOException{
        System.out.println("Enter a word");
        String input = READ.readLine();
        System.out.println();
        permutations = getPermutations.permutations(input);
        WORDS = checksDictionary.findsWords(permutations);
        for (int loop = 0; loop < permutations.size(); loop++) {
            System.out.println(permutations.get(loop));
        }
    }
}
