/*1.Given a matrix and a string, find whether a string is present in the matrix or not a search can be
valid from top to bottom and left to right direction only. */

import java.util.Scanner;
public class MatrixStringSearch {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.println("Enter the number of elements :");
int n = in.nextInt();
String[] matrix = new String[n];
System.out.println("Enter the string matrix(each string have same length):");
for(int i=0;i<n;i++) matrix[i]=in.next();
System.out.println("Enter the input string:");
 String inputString = in.next();

        if (isStringPresent(matrix, inputString)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static boolean isStringPresent(String[] matrix, String inputString) {
        int rows = matrix.length;
        int cols = matrix[0].length();
        int len = inputString.length();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - len; j++) {
                int k;
                for (k = 0; k < len; k++) {
                    if (matrix[i].charAt(j + k)!= inputString.charAt(k)) {
                        break;
                    }
                }
                if (k == len) {
                    return true;
                }
            }
        }

        for (int i = 0; i <= rows - len; i++) {
            for (int j = 0; j < cols; j++) {
                int k;
                for (k = 0; k < len; k++) {
                    if (matrix[i + k].charAt(j) != inputString.charAt(k)) {
                        break;
                    }
                }
                if (k == len) {
                    return true;
                }
            }
        }

        return false;
    }
}
