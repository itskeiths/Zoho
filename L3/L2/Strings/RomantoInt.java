/*2.Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol Value
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as
XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. However, the numeral
for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we
subtract it making four. The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:
I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomantoInt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a Roman numeral: ");
        String roman = in.nextLine();

        int result = romanToInt(roman);

        System.out.println("The integer value of the Roman numeral is: " + result);

    }

    public static int romanToInt(String s) {
        Map<Character, Integer> rm = new HashMap<>();
        rm.put('I', 1);
        rm.put('V', 5);
        rm.put('X', 10);
        rm.put('L', 50);
        rm.put('C', 100);
        rm.put('D', 500);
        rm.put('M', 1000);

        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = rm.get(s.charAt(i));
            if (i < s.length() - 1 && cur < rm.get(s.charAt(i + 1))) {
                res -= cur;
            } else {
                res += cur;
            }
        }
        return res;
    }
}
