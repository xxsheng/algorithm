package day.day26;

import java.util.Arrays;

public class Demo5 {

    public int[] getNearNum(int[] array) {
        // 首先找出比前一个元素大的节点；
        int index = findNumIndex(array);

        // 表示不存在
        if (index == 0) {
            return null;
        }

        int[] newArray = Arrays.copyOf(array, array.length);
        exchangeArray(newArray, index);

        // 将逆序部分重新整理
        reverseArray(newArray, index);

        return newArray;
    }

    private void reverseArray(int[] newArray, int index) {
        for (int i = index, j = newArray.length - 1; i < j; i++, j--) {
            int temp = newArray[i];
            newArray[i] = newArray[j];
            newArray[j] = temp;
        }
    }

    private void exchangeArray(int[] newArray, int index) {
        int data = newArray[index - 1];

        for (int i = newArray.length - 1; i >= index; i--) {
            if (newArray[i] > data) {
                newArray[index] = newArray[i];
                newArray[i] = data;
            }
        }
    }

    private int findNumIndex(int[] array) {
        // 从后往前找
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > array[i - 1]) {
                return i;
            }
        }
        return 0;
    }
}
