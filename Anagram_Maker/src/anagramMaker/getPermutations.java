package anagramMaker;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author fazer
 */
public class getPermutations {

    public ArrayList permutations(String input) {
        getPermutations getPermutations2 = new getPermutations();
        //creates arraylist that will hold all the permutations
        ArrayList<String> permutation = new ArrayList<>();
        //contains the length of the input string
        int length = input.length();
        //re iterates for the length of the input and acts on each letter individually
        for (int loop = 0; loop < length; loop++) {
            //arraylist that contatins all the sub permutations of the word
            ArrayList<String> subPermutations = new ArrayList<>();
            //END CASE OF RECURSION!!
            //if the length of the input is one then add it to subPermutations
            if (length == 1) {
                subPermutations.add(input);
            } //if length > 1 then find the letter of this iteration and work with it 
            else if (length != 1) {
                String letter = new String();
                //gets the letter at the current iteration
                letter += input.charAt(loop);
                //add it if its not already in
                if (!permutation.contains(letter)) {
                    permutation.add(letter);
                }
                String newWord = input.substring(0, loop) + input.substring(loop + 1, length);
                //spawns a new instance of this class with the initial string - the current letter(String letter)
                subPermutations = getPermutations2.permutations(newWord);
            }
            //After the endcase:
            int loop2;
            String outer = new String();
            //does this only if permutations isn't empty
            if (!permutation.isEmpty()) {
                //if the size is one then stores that value in outer
                if (permutation.size() == 1) {
                    outer = permutation.get(loop);
                }//else it finds whichever value has a length of one and stores that in outer 
                else {
                    for (int loop3 = 0; loop3 < permutation.size(); loop3++) {
                        String current = permutation.get(loop3);
                        if (current.length() == 1) {
                            outer = current;
                            //after storing it elsewhere, removes it from the arraylist to minimize complications
                            permutation.remove(loop3);
                        }
                    }
                }
            }
            //adds all subpermutations to the correct letter to create all the permutations of input
            for (loop2 = 0; loop2 < subPermutations.size(); loop2++) {
                //add it if its not already in
                if (!permutation.contains(outer + subPermutations.get(loop2))) {
                    permutation.add(outer + subPermutations.get(loop2));
                }
            }
        }
        //sort the arraylist in alphabetical order
        Collections.sort(permutation);
        //returns the final arraylist with all the permutations of the input
        return permutation;
    }
}
