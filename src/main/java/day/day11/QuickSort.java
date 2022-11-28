package day.day11;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = new int[] {4, 7, 6, 5, 3, 2, 8, 1};
        quickSort.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] array, int startIndex, int endIndex) {
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
        int pivotData = array[left];

        while (left != right) {

            while (right > left && array[right] > pivotData) {
                right--;
            }

            while (right > left && array[left] <= pivotData) {
                left++;
            }

            if (right > left) {
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }

        array[startIndex] = array[left];
        array[left] = pivotData;

        return left;
    }
}
