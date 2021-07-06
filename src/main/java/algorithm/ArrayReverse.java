package algorithm;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] ints = {0, 1, 3,  5, 6,  8, 9,12};
        int[] int1 = {2,3,4,7,10,11,13};
        int[] is = reverseArray(ints);
        System.err.println(Arrays.toString(is));
    }

    static int[] reverseArray(int[] ints) {

        for(int i=0,j=ints.length-1; i<j; i++, j--) {

            int prev = ints[i];
            int tail = ints[j];

            ints[i] = tail;
            ints[j] = prev;
        }

        return ints;
    }

    static int[] reverseArray2(int[] ints) {

        int n = ints.length;
        int m = n + (n & 1);

        for(int i = 0; i <= m / 2; i++) {
            ints[i] = ints[n-i-1] ^ ints[i];
            ints[n-i-1] = ints[n-i-1] ^ ints[i];
            ints[i] = ints[n-i-1] ^ ints[i];
        }
        return ints;
    }
}
