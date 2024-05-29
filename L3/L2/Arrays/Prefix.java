/*3.You are given an array of strings words and a string pref.Return the number of strings in words
that contain pref as a prefix. A prefix of a string s is any leading contiguous substring of s. */

import java.util.Scanner;
public class Prefix {
    public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.println("Enter the number of elements :");
int n = in.nextInt();
String[] words = new String[n];
System.out.println("Enter the elements:");
for(int i=0;i<n;i++)  words[i]=in.next();
System.out.println("Enter the prefix:");
String pref =in.next();
int len = pref.length();
int count=0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length()>=len && words[i].substring(0, len).equals(pref)) {
                count++;
            }
        }
System.out.println("The number of words starting with given prefix: "+count);

    }
}
