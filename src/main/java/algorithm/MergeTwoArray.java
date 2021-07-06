package algorithm;

import java.util.Arrays;

public class MergeTwoArray {
    public static void main(String[] args) {
        int [] array1 = new int[] {1,3,7,9,10,15,0,0,0,0,0,0,0,0};
        int [] array2 = new int[] {2, 5, 6,8,9,10,12,14};
        merge(array1, 6, array2, 8);
        System.out.println(Arrays.toString(array1));
    }

    static int [] mergeTwoArray(int[] array1, int[] array2) {




        return null;
    }

    public static void merge(int nums1 [], int m, int nums2 [], int n){
        int i = m-1, j = n-1, k = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
    }
}
