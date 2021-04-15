package algorithm;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int [] abc = new int[]{6,4,3,7,8,6,10,6,2,0,9,11,1,6,13,5};


        quickSort(abc, 0, abc.length-1);
        System.out.println(Arrays.toString(abc));

    }


    static void quickSort(int [] abc, int start, int end) {
        int ref = abc[start];
        int prev = start;
        int tail = end;

        while (prev < tail) {

            if (abc[tail] > ref) {
                tail--;
            }
            if (abc[prev] < ref) {
                prev++;
            }

            if(abc[prev] == abc[tail] && prev < tail){
                System.out.println(Arrays.toString(abc) + "prev:"+prev + "tail:" +tail);

                prev++;
            } else {
                if (abc[tail] <ref || abc[prev] >ref) {
                    int temp = abc[tail];
                    abc[tail] = abc[prev];
                    abc[prev] = temp;
                }

            }
        }

        if (prev-1 >start ) {
            quickSort(abc, start,prev-1);
        }
        if (tail+1 <end ) {
            quickSort(abc, tail+1,end);
        }
//        quickSort(abc, tail+1, abc.length-1);
    }
}
