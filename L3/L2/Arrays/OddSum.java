
/*2.Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.A
subarray is a contiguous sub sequence of the array. Return the sum of all odd-length sub arrays of
arr. */

import java.util.Scanner;
public class OddSum {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.println("Enter the number of elements :");
int n = in.nextInt();
int[] arr = new int[n];
System.out.println("Enter the elements:");
for(int i=0;i<n;i++) arr[i]=in.nextInt();
 int sum = 0;

        for (int start = 0; start < n; start++) {

            for (int length = 1; start + length <= n; length += 2) {

                for (int i = start; i < start + length; i++) {
                    sum += arr[i];
                }
            }
        }
        System.out.println(sum);
    }

}
