package day.day15;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[] {10, 5, 7, 3, 8, 9, 2, 11, 4, 1};

        HeapSort heapSort = new HeapSort();

        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            heapSort.downAdjust(array, i, array.length);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapSort.downAdjust(array, 0, i);
        }

        System.out.println(Arrays.toString(array));
    }

    private void downAdjust(int[] array, int i, int length) {
        int parentIndex = i;
        int childIndex = 2 * parentIndex + 1;
        int parentData = array[i];

        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            if (array[childIndex] > parentData) {
                array[parentIndex] = array[childIndex];
                parentIndex = childIndex;
                childIndex = 2 * parentIndex + 1;
            } else {
                break;
            }
        }

        array[parentIndex] = parentData;
    }
}
