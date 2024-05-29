
/*8.Given an integer array arr, return the mean of the remaining integers after removing the smallest
5% and the largest 5% of the elements.
Answers within 10-5 of the actual answer will be considered accepted. */
import java.util.Scanner;

public class Mean {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 };

        insertionSort(arr);
        double trimmedMean = calculateTrimmedMean(arr);
        System.out.printf("The trimmed mean is: %.5f\n", trimmedMean);
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static double calculateTrimmedMean(int[] arr) {
        int n = arr.length;
        int trimCount = (int) Math.ceil(n * 0.05);

        int sum = 0;
        for (int i = trimCount; i < n - trimCount; i++) {
            sum += arr[i];
        }

        int remainingElementsCount = n - 2 * trimCount;
        return (double) sum / remainingElementsCount;
    }
}
