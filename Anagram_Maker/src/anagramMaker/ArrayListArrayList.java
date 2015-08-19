/*
 * Takes an arraylist of arraylists and 
 * creates one arraylist of all the contents of each arraylist in the main arraylist
 */
package anagramMaker;

import java.util.ArrayList;

/**
 * @author fazer
 */
public class ArrayListArrayList {

    public ArrayList getAllPermutations(ArrayList ofArrayList) {
        ArrayList allPermutations = new ArrayList();
        for (int loop = 0; loop < ofArrayList.size(); loop++) {
            ArrayList perms = new ArrayList();
            perms = (ArrayList) ofArrayList.get(loop);
            for (int loop2 = 0; loop2 < perms.size(); loop2++) {
                allPermutations.add(perms.get(loop2));
                System.out.println(perms.get(loop2));
            }
        }
        return allPermutations;
    }

}
