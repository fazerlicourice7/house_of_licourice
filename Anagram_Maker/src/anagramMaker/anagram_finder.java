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
        System.out.println("Enter a word");
        String input = READ.readLine();
        System.out.println();
        permutations = getPermutations.permutations(input);
        
        WORDS = checksDictionary.findWords(permutations);
        if (WORDS.size() < 1) {
            System.out.println("There are no anagrams of the string you entered, would you like all the permutations instead?" +"\n" +"'y' or 'n'");
            String input2 = READ.readLine();
            if(input2.equalsIgnoreCase("y")||input2.equalsIgnoreCase("yes")){
                for(int loop = 0; loop <permutations.size(); loop++){
                    System.out.println(permutations.get(loop));
                }
            }
        } else {
            for (int loop = 0; loop < WORDS.size(); loop++) {
                System.out.println(WORDS.get(loop));
            }
        }
    }
}
