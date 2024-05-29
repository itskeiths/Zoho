/*6.Given two strings s and goal, return true if and only if s can become goal after some number of
shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.
For example, if s = "abcde", then it will be "bcdea" after one shift. */

import java.util.Scanner;

public class MatchGoal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = in.next();
        System.out.println("Enter goal: ");
        String goal = in.next();
        if (goal.length() != str.length()) {
            System.out.println(false);
            return;
        }
        String concatenate = str + str;
        for (int i = 0; i < concatenate.length(); i++) {
            if (concatenate.substring(i, i + goal.length()).equals(goal)) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}
