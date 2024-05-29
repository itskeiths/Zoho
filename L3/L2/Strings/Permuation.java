/*7.Given a string array words, return an array of all characters that show up in all strings within the
words (including duplicates). You may return the answer in any order. */

import java.util.Scanner;

public class Permuation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = in.next();
        String res = "";
        for (int i = 0; i < s.length() - 1; i += 2) {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
                    || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' && s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z')) {
                System.out.println(res);
                return;
            }
            res += s.charAt(i + 1);
            res += s.charAt(i);
        }
        System.out.println(res);
    }
}
