/*1.Given two strings s and t, return true if s is a sub sequence of t, or false otherwise.
A sub sequence of a string is a new string that is formed from the original string by deleting some
(can be none) of the characters without disturbing the relative positions of the remaining
characters. (i.e., "ace" is a sub sequence of "abcde" while "aec" is not). */

import java.util.Scanner;

class Subsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String s = in.next();
        System.out.println("Enter second string: ");
        String t = in.next();
        System.out.println("Is subsequence: " + isSubsequence(s, t));
    }

    static boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
