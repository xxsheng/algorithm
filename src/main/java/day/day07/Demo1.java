package day.day07;

public class Demo1 {

    int[] array = new int[10];

    int size = 0;

    public void insert(int data, int index) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException("超出数组范围");
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = data;
        size++;
    }

    public void inser1(int data, int index) {
        if (size == array.length) {
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = data;
        size++;
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出数组范围");
        }
        int data = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return data;
    }
}
