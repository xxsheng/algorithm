package test1;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//算法题：给一个数组A以及一个数字S，求A中两元素相加和为S的索引。要求：算法结果稳定，时间复杂度线性。
//        输入：A: [1 2 3 4 5 6 7] S: 10
//        输出：2 6
public class Test {

    public static void main(String[] args) {
        int[] arrays = new int[]{1,2 ,3, 4, 5, 6, 7};
        int result = 7;
        System.out.println(Arrays.toString(findIndex(arrays, result)));

    }

    static int[] findIndex(int[] arrays, int result) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arrays.length; i++) {
            int data = arrays[i];
            if (map.get(result - data) == null) {
                map.put(data, i);
            } else {
                return new int[] {i, map.get(result-data)};
            }
        }


        return null;
    }
 }
