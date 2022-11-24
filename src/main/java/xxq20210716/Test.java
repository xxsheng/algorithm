package xxq20210716;

import java.util.Arrays;

public class Test {

    /**
     * array1 array2 m n length1 length2 升序
     * l1+l2 = m.l
     *
     */
    public static void main(String[] args) {

        int[] array1 = {1,2,3,0,0,0};
        int[] array2 = {2,5,6};
        sort(array1, array2, 3, 3);
        System.out.println(Arrays.toString(array1));
    }

    public static void sort(int[] m, int[]n, int length1, int length2) {
        if (length1 <0 || length2 <0) {
            return;
        }
        if ( m== null || m.length<=0 ) {
            return;
        }
        if (m.length < (length1+length2)) {
            return;
        }
        int temp = length1 + length2;

        for(;length1>0  && length2>0; ) {
            int data1 = m[length1 - 1];
            int data2 = n[length2 - 1];
            if (data2 > data1) {
                m[temp-1] = data2;
                length2--;
            } else {
                m[temp -1] = data1;
                length1--;
            }
            temp--;


        }

        System.out.println("---");
    }



}
