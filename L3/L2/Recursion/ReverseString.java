
/*2.Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory. */

import java.util.Scanner;
public class ReverseString {

    private static void reverse(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverse(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
 Scanner in = new Scanner(System.in);
System.out.println("Enter the number of elements :");
int n = in.nextInt();
char[] s = new char[n];
System.out.println("Enter the elements:");
for(int i=0;i<n;i++) s[i]=in.next().charAt(0);
        reverse(s, 0, n-1);
        for(int i=0;i<n;i++) System.out.print(s[i]+", ");
    }
}
