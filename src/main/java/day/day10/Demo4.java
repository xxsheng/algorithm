package day.day10;

import java.util.Arrays;

// 快速排序
public class Demo4 {
    int[] array = new int[] {3, 4, 5, 7, 8, 10, 9};

    public static void main(String[] args) {
        //
        Demo4 demo4 = new Demo4();
        demo4.quickSort(demo4.array, 0, demo4.array.length - 1);
        System.out.println(Arrays.toString(demo4.array));
    }

    void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;

        int pivotIndex = doQuickSort(array, startIndex, endIndex);

        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    private int doQuickSort(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];

        int right = endIndex;
        int left = startIndex;
        while (right != left) {

            while (right > left && array[right] > pivot) {
                right--;
            }

            while (right > left && array[left] <= pivot) {
                left++;
            }

            if (right > left) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        int temp = array[left];
        array[left] = pivot;
        array[startIndex] = temp;
        return right;
    }
}
