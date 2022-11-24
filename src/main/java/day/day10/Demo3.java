package day.day10;

import java.util.Arrays;

// 冒泡排序
public class Demo3 {

    // 定义一个数组
    int[] array = new int[] {6, 5, 4, 3, 2, 1};

    public void bubbleSort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                int data1 = array[j];
                int data2 = array[j + 1];
                if (data1 > data2) {
                    array[j] = data2;
                    array[j + 1] = data1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        demo3.bubbleSort();
        System.out.println(Arrays.toString(demo3.array));
    }
}
