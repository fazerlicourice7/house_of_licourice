/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagramMaker;

/**
 *
 * @author fazer
 */
public class getPermutations {

    public static String permutations(String input) {
        int length = input.length();
        for (int loop = 0; loop < length; loop++) {
            String permutations = new String();
            permutations += input.charAt(loop);
            if (input.length() != 1) {
                String newInput = input.substring(0, loop) + input.substring(loop + 1, length);
                permutations += getPermutations.permutations(newInput);
            }
            return permutations;
        }
        return null;
    }

}
