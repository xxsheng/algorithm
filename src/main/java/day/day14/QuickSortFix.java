package day.day14;

import java.util.Arrays;

public class QuickSortFix {

    int[] array = new int[] {6, 7, 5, 3, 9, 10, 2, 1};

    public static void main(String[] args) {
        QuickSortFix quickSortFix = new QuickSortFix();
        quickSortFix.quickSort(quickSortFix.array, 0, quickSortFix.array.length - 1);
        System.out.println(Arrays.toString(quickSortFix.array));
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
        int mark = startIndex;
        int pivotData = array[startIndex];

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
