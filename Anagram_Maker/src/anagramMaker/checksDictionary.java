package anagramMaker;

import java.io.*;
import java.util.ArrayList;

/**
 * @author fazer
 */
public class checksDictionary {

    public static ArrayList findWords(ArrayList permutations) throws FileNotFoundException, IOException {
        //creates a reader which reads words fom a dictionary file
        File dictionary;
        dictionary = new File("/fazer/home/git/house_of_licourice/Anagram_Maker/src/anagramMaker/lowercase100k");
        FileReader fileread = new FileReader(dictionary);
        BufferedReader READFILE = new BufferedReader(fileread);
        //creates an array list in which we will store all our words
        ArrayList<String> words = new ArrayList<>();
        //contains the word from the dictionary that we are currently dealing with
        String currentWord = READFILE.readLine();
        //repeats until the end of the dictionary file
        while (currentWord != null) {
            //adds the current word to our arraylist of words if it is one of our permutations
            if (permutations.contains(currentWord)) {
                words.add(currentWord);
            }
            //reads a new word every iteration
            currentWord = READFILE.readLine();
        }
        return words;
    }
}
