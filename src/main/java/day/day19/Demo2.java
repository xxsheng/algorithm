package day.day19;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        System.out.println(demo2.permute(new int[] {1, 2, 3, 4, 5}));
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length, 0, path, used, res);
        return res;
    }

    private void dfs(
            int[] nums,
            int length,
            int depth,
            Deque<Integer> path,
            boolean[] used,
            List<List<Integer>> res) {

        if (depth == length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            int num = nums[i];
            used[i] = true;
            path.addLast(num);
            dfs(nums, length, depth + 1, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }
}
