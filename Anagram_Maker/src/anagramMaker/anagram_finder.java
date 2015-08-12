package anagramMaker;

import java.io.*;
import java.util.ArrayList;

/**
 * @author 18balanagav
 */
public class anagram_finder {

    static BufferedReader READ = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList permutations;
    static ArrayList WORDS;

    public static void main(String args[]) throws IOException {
        String input;
        input = Interface.getInput();
        permutations = getPermutations.permutations(input);
        WORDS = checksDictionary.findWords(permutations);
        Interface.setOutput(WORDS, permutations);
    }
}
