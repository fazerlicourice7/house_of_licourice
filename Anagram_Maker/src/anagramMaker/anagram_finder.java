package anagramMaker;

import java.io.*;
import java.util.ArrayList;

/**
 * @author fazer
 */
public class anagram_finder {

    static BufferedReader READ = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList permutations;
    static ArrayList WORDS;

    public static void main(String args[]) throws IOException {
        String input;
        Interface3.stuff();
        input = Interface3.getInput();
        permutations = getPermutations.permutations(input);
        WORDS = checksDictionary.findWords(permutations);
        Interface3.setOutput(WORDS, permutations);
    }
}
