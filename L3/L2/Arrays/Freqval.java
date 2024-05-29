/*6.We are given a list nums of integers representing a list compressed with run-length encoding.
Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0). For
each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all
the sublists from left to right to generate the decompressed list.
Return the decompressed list. */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Freqval {
    public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.println("Enter the number of elements :");
int n = in.nextInt();
int[] nums = new int[n];
System.out.println("Enter the elements:");
for(int i=0;i<n;i++) nums[i]=in.nextInt();
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                ans.add(val);
            }
        }
        System.out.println(ans);
    }
}
