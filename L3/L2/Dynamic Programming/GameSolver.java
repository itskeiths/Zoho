/*3.Alice and Bob take turns playing a game, with Alice starting first.
Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move
consisting of:
Choosing any x with 0 < x < n and n % x == 0.
Replacing the number n on the chalkboard with n - x.
Also, if a player cannot make a move, they lose the game.
Return true if and only if Alice wins the game, assuming both players play optimally. */

import java.util.Scanner;

public class GameSolver {

    public static boolean canWin(int n) {
        Boolean[] memo = new Boolean[n + 1];
        return helper(n, memo);
    }

    private static boolean helper(int n, Boolean[] memo) {
        if (n == 1) {
            return false;
        }
        if (memo[n] != null) {
            return memo[n];
        }

        for (int x = 1; x < n; x++) {
            if (n % x == 0) {
                if (!helper(n - x, memo)) {
                    memo[n] = true;
                    return true;
                }
            }
        }
        memo[n] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number (n): ");
        int n = in.nextInt();

        System.out.println("Can Alice win? " + canWin(n));
    }
}
