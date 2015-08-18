package anagramMaker;

import java.util.ArrayList;

/**
 * @author fazer
 */
public class testStuff {

    public static void main(String args[]) {
        getPermutations getperms = new getPermutations();
        ArrayList lol = new ArrayList();
        lol = getperms.subPermutations("hello");
        for (int loop = 0; loop < lol.size(); loop++) {
            System.out.println(lol.get(loop));
        }
    }
}
