/*10.You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the
ith customer has in the jth bank. Return the wealth that the richest customer has.
A customer's wealth is the amount of money they have in all their bank accounts. The richest
customer is the customer that has the maximum wealth. */
public class MaxWealth {
    public static void main(String[] args) {
        int[][] accounts = { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } };
        int maxwealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                wealth += accounts[i][j];
            }
            if (wealth > maxwealth)
                maxwealth = wealth;
        }
        System.out.println(maxwealth);
    }
}
