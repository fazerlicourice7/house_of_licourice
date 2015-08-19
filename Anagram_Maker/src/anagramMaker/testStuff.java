package anagramMaker;

import java.util.ArrayList;

/**
 * @author fazer
 */
public class testStuff {

    public static void main(String args[]) {
        getPermutations getperms = new getPermutations();
        ArrayListArrayList stringFromArrayList = new ArrayListArrayList();
        ArrayList lol = new ArrayList();
        String input = "hi";
        ArrayList totalSPerms = new ArrayList();
            for (int loop = 0; loop < input.length() - 1; loop++) {
                input += " ";
                totalSPerms.add(getperms.permutations(input));
            }
            lol = stringFromArrayList.getAllPermutations(totalSPerms);
        for (int loop = 0; loop < lol.size(); loop++) {
            System.out.println(lol.get(loop));
        }
    }
}
