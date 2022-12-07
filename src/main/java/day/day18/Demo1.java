package day.day18;

import java.util.Arrays;

public class Demo1 {

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        int[] number = {1, 2, 3, 4, 5};
        for (int i = 0; i < 100; i++) {
            number = demo1.findNearestNumber(number);
            if (number == null) break;
            System.out.println(Arrays.toString(number));
        }
    }

    public int[] findNearestNumber(int[] array) {
        int index = findPoint(array);

        if (index == 0) {
            return null;
        }
        int[] temp = Arrays.copyOf(array, array.length);

        transferData(temp, index);

        reverseArray(temp, index);

        return temp;
    }

    private void reverseArray(int[] temp, int index) {
        for (int i = index, j = temp.length - 1; i < j; i++, j--) {
            int data = temp[i];
            temp[i] = temp[j];
            temp[i] = data;
        }
    }

    private void transferData(int[] temp, int index) {
        for (int i = temp.length - 1; i >= index; i--) {
            if (temp[i] > temp[index - 1]) {
                int data = temp[i];
                temp[i] = temp[index - 1];
                temp[index - 1] = data;
                return;
            }
        }
    }

    private int findPoint(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] > array[i - 1]) {
                return i;
            }
        }
        return 0;
    }
}
