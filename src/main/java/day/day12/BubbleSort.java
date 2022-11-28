package day.day12;

import java.util.Arrays;

public class BubbleSort {

    int[] array = new int[] {4, 7, 3, 6, 9, 1, 10};

    void bubbleSort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort();
        System.out.println(Arrays.toString(bubbleSort.array));
    }
}
