package day.day14;

import java.util.Arrays;

public class BubbleSortFix1 {
    int[] array = new int[] {4, 6, 7, 3, 8, 9, 10, 1};

    public static void main(String[] args) {
        BubbleSortFix1 bubbleSortFix1 = new BubbleSortFix1();
        bubbleSortFix1.sort();
        System.out.println(Arrays.toString(bubbleSortFix1.array));
    }

    public void sort() {

        for (int i = 0; i < array.length / 2; i++) {
            boolean isSorted = true;
            for (int j = i; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }

            for (int j = array.length - 1 - i; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j] = array[j - 1];
                    array[j] = temp;
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }

    //    public void sort1() {
    //
    //        int lastIndex = array.length - 1;
    //        for (int i = 0; i < array.length / 2; i++) {
    //            boolean isSorted = true;
    //            for (int j = i; j < lastIndex; j++) {
    //
    //                if (array[j] > array[j + 1]) {
    //                    int temp = array[j];
    //                    array[j] = array[j + 1];
    //                    array[j + 1] = temp;
    //                    lastIndex = j;
    //                    isSorted =false;
    //                }
    //            }
    //
    //            if (isSorted) {
    //                break;
    //            }
    //
    //            for (int j = array.length-1-i; j < i; j--) {
    //
    //            }
    //        }
    //    }
}
