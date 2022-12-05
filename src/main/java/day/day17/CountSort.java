package day.day17;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        CountSort countSort = new CountSort();

        int[] array = new int[] {9, 3, 5, 4, 9, 1, 2, 7, 8, 1, 3, 6, 5, 3, 4, 0, 10, 9, 7, 9};
        System.out.println(Arrays.toString(countSort.countSort(array)));

        int[] array1 = new int[] {95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        System.out.println(Arrays.toString(countSort.countSortV2(array1)));
        System.out.println(Arrays.toString(countSort.countSortV3(array1)));
    }

    public int[] countSort(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (i > max) {
                max = i;
            }

            if (i < min) {
                min = i;
            }
        }

        int[] countArray = new int[max - min + 1];
        for (int number : array) {
            countArray[number] = countArray[number] + 1;
        }

        int[] sortedArray = new int[array.length];
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int count = 0; count < countArray[i]; count++) {
                sortedArray[index++] = i;
            }
        }

        return sortedArray;
    }

    public int[] countSortV2(int[] array) {
        int max = array[0];
        int min = array[0];

        for (int number : array) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }

        int[] countArray = new int[max - min + 1];
        for (int number : array) {
            countArray[number - min] = countArray[number - min] + 1;
        }

        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int count = 0; count < countArray[i]; count++) {
                sortedArray[index++] = i + min;
            }
        }
        return sortedArray;
    }

    public int[] countSortV3(int[] array) {
        int max = array[0];
        int min = array[0];

        for (int number : array) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }

        int[] countArray = new int[max - min + 1];
        for (int number : array) {
            countArray[number - min] = countArray[number - min] + 1;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i] + countArray[i - 1];
        }

        int[] sortedArray = new int[array.length];

        for (int number : array) {
            int i = number - min;
            int count = countArray[i];
            sortedArray[count - 1] = number;
            countArray[i] = countArray[i] - 1;
        }

        return sortedArray;
    }
}
