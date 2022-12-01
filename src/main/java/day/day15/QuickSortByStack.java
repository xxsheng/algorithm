package day.day15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QuickSortByStack {

    int[] array = new int[] {4, 3, 6, 8, 9, 1, 5, 2, 10};

    public static void main(String[] args) {
        QuickSortByStack quickSortByStack = new QuickSortByStack();
        quickSortByStack.quickSort();
        System.out.println(Arrays.toString(quickSortByStack.array));
    }

    public void quickSort() {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("endIndex", array.length - 1);
        stack.push(map);

        while (!stack.isEmpty()) {
            Map<String, Integer> popMap = stack.pop();
            Integer startIndex = popMap.get("startIndex");
            Integer endIndex = popMap.get("endIndex");
            int pivotIndex = doQuickSort(array, startIndex, endIndex);

            if (startIndex < pivotIndex - 1) {
                HashMap<String, Integer> tempMap = new HashMap<>();
                tempMap.put("startIndex", startIndex);
                tempMap.put("endIndex", pivotIndex - 1);
                stack.push(tempMap);
            }

            if (pivotIndex + 1 < endIndex) {
                HashMap<String, Integer> tempMap = new HashMap<>();
                tempMap.put("startIndex", pivotIndex + 1);
                tempMap.put("endIndex", endIndex);
                stack.push(tempMap);
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
