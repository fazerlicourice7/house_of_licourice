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
public class permutations {

    public static void permutations(String permutation, String input) {
        int length = input.length();
        if (length == 0) {
            System.out.println(permutation);
        } else {
            for (int loop = 0; loop < length; loop++) {
                permutations((permutation + input.charAt(loop)), (input.substring(0, loop) + input.substring(loop + 1, length)));
            }
        }
    }
}
