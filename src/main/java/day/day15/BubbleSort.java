package day.day15;

import java.util.Arrays;

public class BubbleSort {

    int[] array = new int[] {4, 3, 6, 8, 9, 1, 5, 2, 10};

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort();
        System.out.println(Arrays.toString(bubbleSort.array));
    }

    public void bubbleSort() {
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSorted = true;

            for (int j = i; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    isSorted = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            if (isSorted) {
                break;
            }

            for (int j = array.length - 1 - i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }
}
