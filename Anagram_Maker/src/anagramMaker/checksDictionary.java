package anagramMaker;

import java.io.*;
import java.util.ArrayList;

/**
 * @author fazer
 */
public class checksDictionary {

    public ArrayList findWords(ArrayList permutations) throws FileNotFoundException, IOException {
        //creates a reader which reads words fom a dictionary file
        File dictionary;
        dictionary = new File("lowercase100k.txt");
        FileReader fileread = new FileReader(dictionary);
        BufferedReader READFILE = new BufferedReader(fileread);
        BufferedReader READFILE2 = new BufferedReader(fileread);
        //creates an array list in which we will store all our words
        ArrayList<String> words = new ArrayList<>();
        //checks if the permutations have spaces in them
        String hasSpace = (String) permutations.get(0);
        if (hasSpace.contains(" ")) {
            //if they do then split it up into an array and check each seperate string to see if it is a word
            //reads and adds all the words in the dictionary into an arraylist
            String currentWord = new String();
            currentWord = READFILE2.readLine();
            //creates an arraylist which will contain all the dictionary words
            ArrayList<String> dictionaryWords = new ArrayList<>();
            while (currentWord != null) {
                dictionaryWords.add(currentWord);
                currentWord = READFILE2.readLine();
            }
            for (int loop = 0; loop < permutations.size(); loop++) {
                //contains the current permutation we are dealing with
                String currentPermutation = (String) (permutations.get(loop));
                //splits it at the space and stores it in an array
                String[] Words = currentPermutation.split(" ");
                //creates an int that will hold the number of strings out of the total strings in the 
                //permutation that are words
                int yes = 0;
                //runs through all of the strings and checks if they are words in the dictionary
                for (int loop2 = 0; loop2 < Words.length; loop2++) {
                    if (dictionaryWords.contains(Words[loop2])) {
                        yes++;
                    }
                }
                //if they are all words in the dictionary then add them
                if (yes == Words.length) {
                    //gets rid of repeats 
                    if (!words.contains((String) permutations.get(loop))) {
                        words.add((String) permutations.get(loop));
                    }
                }
            }
        } else {
            //contains the word from the dictionary that we are currently dealing with
            String currentWord = READFILE.readLine();
            //repeats until the end of the dictionary file
            while (currentWord != null) {
                //adds the current word to our arraylist of words if it is one of our permutations
                if (permutations.contains(currentWord)) {
                    //gets rid of repeats
                    if (!words.contains(currentWord)) {
                        words.add(currentWord);
                    }
                }
                //reads a new word every iteration
                currentWord = READFILE.readLine();
            }
        }
        return words;
    }
}
