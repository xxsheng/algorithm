package day.day09;

import java.util.Arrays;

public class BinaryHeap {

    // 上浮
    public static void upAdjust(int[] array) {
        // 找出最后一个节点
        int childIndex = array.length - 1;
        // 先拿出需要上浮节点的值
        int temp = array[childIndex];
        // 根据推算找出节点的父节点
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0 && array[parentIndex] > temp) {
            // 如果父节点值大于子节点，则进行交换
            array[childIndex] = array[parentIndex];

            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[parentIndex] = temp;
    }

    public static void downAdjust(int[] array, int parentIndex, int length) {
        // 先拿出父节点的值
        int parentData = array[parentIndex];
        // 得到左子节点的位置
        int childIndex = 2 * parentIndex + 1;

        // 当子节点的下标已经超出数组下标，跳出循环
        while (childIndex < length) {

            // 定位左子节点和右子节点的大小
            if (childIndex + 1 < array.length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个子节点则跳出
            if (parentData < array[childIndex]) {
                return;
            }

            // 将子节点上浮，然后下标进行下浮
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }

        // 最后跳出循环的点，是父节点已经不存在子节点了，已经遍历到根节点，进行赋值
        array[parentIndex] = parentData;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }

    private static void buildHeap(int[] array) {
        // 构造二叉堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }
}
