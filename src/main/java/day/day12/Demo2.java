package day.day12;

import java.util.Arrays;

public class Demo2 {

    public static void main(String[] args) {
        int[] array = new int[] {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
        // [1, 5, 2, 6, 7, 3, 8, 9, 10]
    }

    private static void buildHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i);
        }
    }

    private static void downAdjust(int[] array, int index) {
        int parentIndex = index;
        int parentData = array[index];
        int childIndex = 2 * parentIndex + 1;

        while (childIndex < array.length) {
            if (childIndex + 1 < array.length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }

            if (parentData > array[childIndex]) {
                array[parentIndex] = array[childIndex];
                parentIndex = childIndex;
                childIndex = 2 * parentIndex + 1;
            } else {
                break;
            }
        }

        array[parentIndex] = parentData;
    }

    private static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int child = array[childIndex];
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0 && array[parentIndex] > child) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }

        array[childIndex] = child;
    }
}
