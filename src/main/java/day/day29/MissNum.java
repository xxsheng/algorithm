package day.day29;

import java.util.Arrays;

public class MissNum {

    public static void main(String[] args) {
        int[] array = {4, 1, 2, 2, 5, 1, 4, 3};
        int[] misNumArray = getMissNum(array);
        System.out.println(Arrays.toString(misNumArray));
    }

    private static int[] getMissNum(int[] array) {
        int result = 0;
        for (int data : array) {

            result ^= data;
        }
        if (result == 0) {
            return null;
        }

        int flag = 1;
        while (0 == (result & flag)) {
            flag <<= 1;
        }

        int[] resultArray = new int[2];
        for (int data : array) {
            if ((data & flag) == 0) {
                resultArray[0] ^= data;
            } else {
                resultArray[1] ^= data;
            }
        }

        return resultArray;
    }
}
