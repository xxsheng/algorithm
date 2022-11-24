package day.day07;

import day.day04.TreeDemo1.TreeNode;

public class Demo4 {

    public static void main(String[] args) {
        Integer[] array =
                new Integer[] {3, 2, 9, null, null, 10, null, null, 8, null, 4, null, null};

        TreeNode treeNode = buildTree(array, 0);
    }

    private static TreeNode buildTree(Integer[] array, int index) {
        if (index <= array.length - 1) {
            Integer integer = array[index];
            index = index + 1;
            if (integer == null) return null;
            TreeNode left = buildTree(array, index);
            TreeNode right = buildTree(array, index);
            return new TreeNode(left, right, integer);
        }

        return null;
    }
}
