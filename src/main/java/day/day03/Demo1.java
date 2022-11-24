package day.day03;

import org.junit.Test;

public class Demo1 {
    private int[] numbers = new int[10];

    private int size;

    @Test
    public void test1() {
        insert(3, 0);
        insert(7, 1);
        insert(9, 2);
        insert(5, 3);
        insert(6, 1);
        output();
        delete(0);
    }

    private void delete(int index) {
        if (index < 0 || index > numbers.length - 1) {
            throw new IndexOutOfBoundsException("数组下标越界");
        }
        for (int i = index; i < size; i++) {

            numbers[i] = numbers[i + 1];
        }
    }

    private void insert(int number, int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际的大小");
        }

        if (size == numbers.length) {
            resize();
        }

        for (int i = size - 1; i >= index; i--) {
            numbers[i + 1] = numbers[i];
        }

        numbers[index] = number;
        size++;
    }

    private void resize() {
        // 进行扩容
        int[] newArray = new int[numbers.length * 2];
        for (int i = 0; i < numbers.length; i++) {
            newArray[i] = numbers[i];
        }
        numbers = newArray;
    }

    private void output() {
        for (int number : numbers) {
            System.out.print(number);
        }
    }
}
