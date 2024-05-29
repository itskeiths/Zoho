/*1.Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory. */

import java.util.Scanner;
public class Reverse {
    public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.println("Enter the number of elements :");
int n = in.nextInt();
char[] s = new char[n];
System.out.println("Enter the elements:");
for(int i=0;i<n;i++) s[i]=in.next().charAt(0);
        int i = 0, j = n - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        for (char c : s)
            System.out.print(c);
    }
}
