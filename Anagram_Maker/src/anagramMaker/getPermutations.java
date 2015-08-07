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

    static ArrayList<String> permutation = new ArrayList<>();

    public static ArrayList permutations(String input) {
        int length = input.length();
        for (int loop = 0; loop < length; loop++) {
            String letter = new String();
            letter += input.charAt(loop);
            permutation.add(letter);
            String newInput = input.substring(0, loop) + input.substring(loop + 1, length);
            ArrayList<String> subPermutations = getPermutations.permutations(newInput);
            if (length == 1) {
                for (int loop2 = 0; loop2 < permutation.size(); loop2++) {
                    permutation.add((loop + loop2), (permutation.get(loop) + subPermutations.get(loop2)));
                }
            }
        }
        return permutation;
    }
}
