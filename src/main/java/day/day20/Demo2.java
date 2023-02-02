package day.day20;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        System.out.println(demo2.permute(new int[] {1, 2, 3, 4, 5}));
    }

    List<List<Integer>> permute(int[] array) {

        List<List<Integer>> result = new ArrayList<>();
        if (array == null || array.length == 0) {
            return result;
        }

        boolean[] used = new boolean[array.length];
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(array, array.length, 0, used, stack, result);
        return result;
    }

    private void dfs(
            int[] array,
            int length,
            int depth,
            boolean[] used,
            Deque<Integer> stack,
            List<List<Integer>> result) {

        if (depth == length) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            stack.addLast(array[i]);
            dfs(array, length, depth + 1, used, stack, result);
            used[i] = false;
            stack.removeLast();
        }
    }
}
