package day.day14;

import java.util.Arrays;

public class HeapSort {

    public void downAdjust(int[] array, int parentIndex, int length) {
        int childIndex = 2 * parentIndex + 1;
        int parentData = array[parentIndex];

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

    void heapSort(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }

        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            downAdjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {10, 5, 7, 3, 8, 9, 2, 11, 4, 1};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
