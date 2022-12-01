package day.day15;

import java.util.Arrays;

public class CountSortFix {
    int[] array = new int[] {95, 94, 91, 98, 99, 90, 99, 93, 91, 92};

    public static void main(String[] args) {
        CountSortFix countSortFix = new CountSortFix();
        System.out.println(Arrays.toString(countSortFix.countSort()));
    }

    int[] countSort() {
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

        for (int i = 0; i < countArray.length - 1; i++) {
            countArray[i + 1] = countArray[i] + countArray[i + 1];
        }

        int[] sortedArray = new int[array.length];
        for (int number : array) {
            int count = countArray[number - min];
            sortedArray[count - 1] = number;
            countArray[number - min] = countArray[number - min] - 1;
        }

        return sortedArray;
    }
}
