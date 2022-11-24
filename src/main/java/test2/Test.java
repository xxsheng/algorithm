package test2;


public class Test {
   static int count=0;
    public static void main(String[] args) {
        // 1 2 3 4 5 6
        int[] arrays = {1, 2, 3, 4};
        perm(arrays, 0, arrays.length-1);
        System.out.println(count);
    }


    static void perm(int[] array, int x, int y) {
        if (x==y) {
            printArray(array);
        }
        for (int i = x; i <= y; i++) {
            swap(array, x, i);
            perm(array, x+1, y);
            swap(array, i, x);
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
        count++;
        System.out.println();
    }

}
