
/*4.There are n kids with candies. You are given an integer array candies, where each candies[i]
represents the number of candies the ith kid has, and an integer extraCandies, denoting the
number of extra candies that you have. Return a Boolean array result of length n, where result[i] is
true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies
among all the kids, or false otherwise. */

import java.util.Scanner;
public class Candies {
    public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.println("Enter the number of elements :");
int n = in.nextInt();
int[] candies = new int[n];
System.out.println("Enter the elements:");
for(int i=0;i<n;i++) candies[i]=in.nextInt();
System.out.println("Enter the extra candies:");
int extraCandies = in.nextInt();
        int max = 0;
        boolean[] result = new boolean[candies.length];
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                result[i] = true;
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+", ");
        }
    }
}
