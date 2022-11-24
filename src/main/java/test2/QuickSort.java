package test2;

public class QuickSort {

    public static void main(String[] args) {
        int[] arrays = {5, 8, 7, 9, 6, 18, 14, 12, 17};


    }

    static void quickSort(int[] arrays, int start, int end) {

        int index = arrays.length / 2;
        int i = start;
        int j = end;


        while (arrays[i] < arrays[index]) {
            i++;
        }

        while (arrays[j] > arrays[index]) {
            j--;
        }

//        while ()

    }
}
