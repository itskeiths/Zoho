/*7.Given a string array words, return an array of all characters that show up in all strings within the
words (including duplicates). You may return the answer in any order. */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommonCharacters {
    public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.println("Enter the number of elements :");
int n = in.nextInt();
String[] str = new String[n];
System.out.println("Enter the elements:");
for(int i=0;i<n;i++) str[i]=in.next();
System.out.println(commonChars(str));
    }

    public static List<Character> commonChars(String[] words) {
        List<Character> result = new ArrayList<>();
        int[] minFreq = new int[26];
        for (int i = 0; i < minFreq.length; i++) {
            minFreq[i] = Integer.MAX_VALUE;
        }

        for (String word : words) {
            int[] charFreq = new int[26];
            for (char c : word.toCharArray()) {
                charFreq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charFreq[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                result.add((char) (i + 'a'));
            }
        }

        return result;
    }
}
