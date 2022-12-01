package day.day13;

import java.util.Arrays;

public class BubbleSortFix {

    int[] array = new int[] {5, 4, 3, 2, 1, 6, 7, 8, 9, 10, 11};

    public static void main(String[] args) {
        BubbleSortFix bubbleSortFix = new BubbleSortFix();
        bubbleSortFix.bubbleSort();
        System.out.println(Arrays.toString(bubbleSortFix.array));
    }

    void bubbleSort() {
        boolean flag = false;
        int lastIndex = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < lastIndex; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    lastIndex = j;
                }
            }

            if (!flag) {
                System.out.println(flag);
                break;
            }
        }
    }
}
