package day.day04;

import java.util.ArrayList;
import java.util.List;

public class TreeDemo1 {

    Integer[] array = new Integer[] {1, 2, 3, 4, 5, null, 6, null, 8};

    public void buildTree() {}

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(null, null, 9);
        TreeNode treeNode2 = new TreeNode(null, null, 8);
        TreeNode treeNode3 = new TreeNode(null, null, 7);
        TreeNode treeNode4 = new TreeNode(null, null, 6);
        TreeNode treeNode5 = new TreeNode(treeNode1, null, 5);
        TreeNode treeNode6 = new TreeNode(treeNode2, null, 4);
        TreeNode treeNode7 = new TreeNode(treeNode4, treeNode3, 3);
        TreeNode treeNode8 = new TreeNode(treeNode6, treeNode5, 2);
        TreeNode treeNode9 = new TreeNode(treeNode8, treeNode7, 1);

        //        System.out.println(treeNode9.data);
        //        treeSearch(treeNode9);
        //        treeSearch(treeNode9.left);
        //        treeSearch(treeNode9.right);
        //
        //        treeSearch(treeNode9.left.left);
        //        treeSearch(treeNode9.left.right);
        //
        //        treeSearch(treeNode9.right.left);
        //        treeSearch(treeNode9.right.right);

        TreeDemo1 treeDemo1 = new TreeDemo1();
        //        treeDemo1.treeBfsToArray(treeNode9);
        ArrayList<List<Integer>> result = new ArrayList<>();
        treeDemo1.treeBfsByRecursion(treeNode9, 0, result);
        System.out.println(result);
    }

    public static void treeSearch(TreeNode treeNode) {

        if (treeNode == null) return;

        if (treeNode.left != null) {
            System.out.println(treeNode.left.data);
        }

        if (treeNode.right != null) {
            System.out.println(treeNode.right.data);
        }
    }

    public void treeBfsByLinkedList(TreeNode treeNode) {

        java.util.LinkedList<TreeNode> linkedList = new java.util.LinkedList<TreeNode>();
        linkedList.addLast(treeNode);

        while (!linkedList.isEmpty()) {

            TreeNode node = linkedList.removeFirst();
            System.out.println(node.data);
            if (node.left != null) linkedList.addLast(node.left);
            if (node.right != null) linkedList.addLast(node.right);
        }
    }

    public void treeBfsByRecursion(TreeNode treeNode, int level, List<List<Integer>> result) {

        if (treeNode == null && level == result.size()) {
            return;
        }

        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(treeNode == null ? null : treeNode.data);
        if (treeNode != null) {

            treeBfsByRecursion(treeNode.left, level + 1, result);
            treeBfsByRecursion(treeNode.right, level + 1, result);
        }
    }

    public void treeBfsToArray(TreeNode treeNode) {

        java.util.LinkedList<TreeNode> linkedList = new java.util.LinkedList<TreeNode>();
        linkedList.addLast(treeNode);

        Integer[] integers = new Integer[15];
        int index = 0;
        while (!linkedList.isEmpty()) {

            TreeNode node = linkedList.removeFirst();

            if (node == null) {
                integers[index] = null;
                index++;
                continue;
            } else {
                integers[index] = node.data;
                index++;
            }

            if (node.left == null && node.right == null) {
                continue;
            }
            linkedList.addLast(node.left);
            linkedList.addLast(node.right);
        }

        for (Integer integer : integers) {
            System.out.print(integer);
        }
    }

    public static class TreeNode {

        private TreeNode left;

        private TreeNode right;

        private int data;

        public TreeNode(TreeNode left, TreeNode right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public int getData() {
            return data;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }
}
