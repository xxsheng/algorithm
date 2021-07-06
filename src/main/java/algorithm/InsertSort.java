package algorithm;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int [] arrays = new int[] {2,1,5,3,6,4,9,8,7};

        for (int i = 1; i < arrays.length; i++) {
            int a = arrays[i];
            for (int j = i; j>= 0; j--) {
//                int b = arrays[j];

                if (j >0 && a < arrays[j - 1]) {

                    arrays[j] = arrays[j - 1];
                } else {
                    arrays[j] = a;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arrays));
    }
}
