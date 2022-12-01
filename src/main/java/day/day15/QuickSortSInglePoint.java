package day.day15;

import java.util.Arrays;

public class QuickSortSInglePoint {
    int[] array = new int[] {4, 3, 6, 8, 9, 1, 5, 2, 10};

    public static void main(String[] args) {
        QuickSortSInglePoint quickSortSInglePoint = new QuickSortSInglePoint();
        quickSortSInglePoint.quickSort(
                quickSortSInglePoint.array, 0, quickSortSInglePoint.array.length - 1);
        System.out.println(Arrays.toString(quickSortSInglePoint.array));
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
        int pivotData = array[startIndex];
        int mark = startIndex;

        for (int i = startIndex; i <= endIndex; i++) {
            if (array[i] < pivotData) {
                mark++;
                int temp = array[i];
                array[i] = array[mark];
                array[mark] = temp;
            }
        }

        array[startIndex] = array[mark];
        array[mark] = pivotData;

        return mark;
    }
}
