
/*5.You are given a string s consisting of digits and an integer k.
A round can be completed if the length of s is greater than k. In one round, do the following:

Divide s into consecutive groups of size k such that the first k characters are in the first group,
the next k characters are in the second group, and so on. Note that the size of the last group can
be smaller than k.
Replace each group of s with a string representing the sum of all its digits. For example, "346" is
replaced with "13" because 3 + 4 + 6 = 13.
Merge consecutive groups together to form a new string. If the length of the string is greater than
k, repeat from step 1. Return s after all rounds have been completed. */

import java.util.Scanner;

public class DigitSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the string of digits: ");
        String s = in.next();

        System.out.print("Enter the integer k: ");
        int k = in.nextInt();

        while (s.length() > k) {
            String newS = "";
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                for (int j = i; j < i + k && j < s.length(); j++) {
                    sum += s.charAt(j) - '0';
                }
                newS += sum;
            }
            s = newS;
        }

        System.out.println(s);
    }
}
