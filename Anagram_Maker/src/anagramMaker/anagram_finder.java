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
        Interface3 gui = new Interface3();
        gui.initialize();
    }
}
