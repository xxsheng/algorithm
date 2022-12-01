package day.day14;

import java.util.Arrays;

public class CountSort {
    int[] array = new int[] {9, 3, 5, 4, 9, 1, 2, 7, 8, 1, 3, 6, 5, 3, 4, 0, 10, 9, 7, 9};

    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        System.out.println(Arrays.toString(countSort.countSort()));
    }

    int[] countSort() {
        int max = 0;

        for (int number : array) {
            if (number > max) {
                max = number;
            }
        }

        int[] temp = new int[max + 1];

        for (int number : array) {
            temp[number] = temp[number] + 1;
        }

        int[] sortedArray = new int[array.length];

        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {
                sortedArray[index++] = i;
            }
        }

        return sortedArray;
    }
}
