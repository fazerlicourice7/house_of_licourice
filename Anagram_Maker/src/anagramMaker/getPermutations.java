/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagramMaker;

import java.util.ArrayList;

/**
 * @author fazer
 */
public class getPermutations {

    public static ArrayList permutations(String input) {
        ArrayList<String> permutation = new ArrayList<>();
        int length = input.length();
        for (int loop = 0; loop < length; loop++) {
            ArrayList<String> subPermutations = new ArrayList<>();
            if (length == 1) {
                subPermutations.add(input);
            } else if (length != 1) {
                String letter = new String();
                letter += input.charAt(loop);
                permutation.add(letter);
                String newWord = input.substring(0, loop) + input.substring(loop + 1, length);
                subPermutations = getPermutations.permutations(newWord);
            }
            int loop2;
            for (loop2 = 0; loop2 < subPermutations.size(); loop2++) {
                String outer = new String();
                if (permutation.size() > 0) {
                    outer = permutation.get(loop);
                }
                permutation.add((loop + loop2), (outer + subPermutations.get(loop2)));
                /*if (permutation.size() > 1) {
                    permutation.remove(loop + loop2 + 1);
                }*/
            }
        }
        return permutation;
    }
}
