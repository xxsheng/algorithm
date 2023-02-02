package day.day22;

import java.util.Arrays;

public class Demo3 {

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        int[] array = {4, 1, 2, 2, 5, 1, 4, 3};
        System.out.println(Arrays.toString(demo3.findNum(array)));
    }

    private int[] findNum(int[] array) {
        int[] result = new int[2];

        int num = 0;
        for (int data : array) {
            num = num ^ data;
        }

        int temp = 1;
        while (0 == (num & temp)) {
            temp <<= 1;
        }

        for (int data : array) {
            if (0 == (data & temp)) {
                result[0] ^= data;
            } else {
                result[1] ^= data;
            }
        }

        return result;
    }
}
