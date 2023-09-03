package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swaped = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    swaped = true;
                }
            }
            if (!swaped) {
                break;
            }
        }
    }

    public static void selectedSort(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            int midIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[midIndex]) {
                    midIndex=j;
                }
            }
            swap(arr,i,midIndex);
        }
    }


    public static void main(String[] args) {

        Random random = new Random();
        int[] a = random.ints(10, 0, 10).toArray();
        System.out.println("Before Sort");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

//        Sort.bubbleSort(a);
        Sort.selectedSort(a);

        System.out.println("\nAfter Sort");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
