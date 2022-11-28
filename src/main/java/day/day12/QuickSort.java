package day.day12;

import java.util.Arrays;

public class QuickSort {
    int[] array = new int[] {4, 7, 3, 6, 9, 1, 10};

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(quickSort.array, 0, quickSort.array.length - 1);
        System.out.println(Arrays.toString(quickSort.array));
    }

    void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = doQuickSort(array, startIndex, endIndex);

        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    private int doQuickSort(int[] array, int startIndex, int endIndex) {

        int left = startIndex;
        int right = endIndex;
        int pivotData = array[startIndex];

        while (left != right) {
            while (right > left && array[right] > pivotData) {
                right--;
            }

            while (right > left && array[left] <= pivotData) {
                left++;
            }

            if (right > left) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        array[startIndex] = array[left];
        array[left] = pivotData;

        return left;
    }
}
