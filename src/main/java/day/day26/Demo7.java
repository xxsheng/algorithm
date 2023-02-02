package day.day26;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Demo7 {

    public static void main(String[] args) {
        Demo7 demo7 = new Demo7();
        System.out.println(demo7.getPermute(new int[] {1, 2, 3, 4, 5}));
    }

    public List<List<Integer>> getPermute(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        if (array == null || array.length == 0) {
            return result;
        }

        boolean[] used = new boolean[array.length];
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(array, array.length, used, stack, result, 0);
        return result;
    }

    private void dfs(
            int[] array,
            int length,
            boolean[] used,
            Deque<Integer> stack,
            List<List<Integer>> result,
            int depth) {
        if (depth == length) {
            result.add(new ArrayList<>(stack));
        }
        for (int i = 0; i < array.length; i++) {
            if (used[i]) {
                continue;
            }
            stack.addLast(array[i]);
            used[i] = true;
            dfs(array, length, used, stack, result, depth + 1);
            used[i] = false;
            stack.removeLast();
        }
    }
}
