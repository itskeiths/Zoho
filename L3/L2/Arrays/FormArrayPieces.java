/*9.You are given an array of distinct integers arr and an array of integer arrays pieces, where the
integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any
order. However, you are not allowed to reorder the integers in each array pieces[i].
Return true if it is possible to form the array arr from pieces. Otherwise, return false. */

public class FormArrayPieces {
    public static void main(String[] args) {
        int[] arr1 = { 15, 88 };
        int[][] pieces1 = { { 88 }, { 15 } };
        System.out.println(canFormArray(arr1, pieces1)); 

        int[] arr2 = { 49, 18, 16 };
        int[][] pieces2 = { { 16, 18, 49 } };
        System.out.println(canFormArray(arr2, pieces2)); 

        int[] arr3 = { 91, 4, 64, 78 };
        int[][] pieces3 = { { 78 }, { 4, 64 }, { 91 } };
        System.out.println(canFormArray(arr3, pieces3)); 
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        int i = 0;
        while (i < arr.length) {
            boolean found = false;
            for (int[] piece : pieces) {
                if (arr[i] == piece[0]) {
                    found = true;
                    for (int j = 0; j < piece.length; j++) {
                        if (i + j >= arr.length || arr[i + j] != piece[j]) {
                            return false;
                        }
                    }
                    i += piece.length;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
