package day.day14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QuickSortFix2 {
    int[] array = new int[] {5, 7, 3, 9, 8, 2, 1, 10, 11};

    public static void main(String[] args) {
        QuickSortFix2 quickSortFix2 = new QuickSortFix2();
        quickSortFix2.quickSort();
        System.out.println(Arrays.toString(quickSortFix2.array));
    }

    public void quickSort() {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("endIndex", array.length - 1);
        stack.push(map);

        while (!stack.isEmpty()) {
            Map<String, Integer> map1 = stack.pop();
            int pivotIndex = doQuickSort(array, map1.get("startIndex"), map1.get("endIndex"));

            if (pivotIndex - 1 > map1.get("startIndex")) {
                Map<String, Integer> temp = new HashMap<>();
                temp.put("startIndex", map1.get("startIndex"));
                temp.put("endIndex", pivotIndex - 1);
                stack.push(temp);
            }

            if (pivotIndex + 1 < map1.get("endIndex")) {
                Map<String, Integer> temp = new HashMap<>();
                temp.put("startIndex", pivotIndex + 1);
                temp.put("endIndex", map1.get("endIndex"));
                stack.push(temp);
            }
        }
    }

    private int doQuickSort(int[] array, Integer startIndex, Integer endIndex) {
        int mark = startIndex;
        int pivotData = array[startIndex];

        for (int i = startIndex; i <= endIndex; i++) {
            if (array[i] < pivotData) {
                mark++;
                int temp = array[i];

                array[i] = array[mark];
                array[mark] = temp;
            }
        }

        array[startIndex] = array[mark];
        array[mark] = pivotData;
        return mark;
    }
}
