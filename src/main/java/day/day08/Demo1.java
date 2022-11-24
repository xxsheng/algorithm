package day.day08;

import java.util.Arrays;

// 二叉堆
public class Demo1 {
    // 堆的上浮
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];

        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }

        array[childIndex] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }

    // array.length 为数组长度， -1表示末尾元素下标，再根据二叉树得下标推断，从最后一个根节点进行遍历
    private static void buildHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    private static void downAdjust(int[] array, int parentIndex, int length) {
        int parentData = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;

        while (childIndex < length) {
            if (childIndex + 1 < array.length && array[childIndex] > array[childIndex + 1]) {
                childIndex++;
            }
            if (parentData <= array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }

        array[parentIndex] = parentData;
    }
}
