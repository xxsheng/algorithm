package day.day05;

import day.day04.TreeDemo1.TreeNode;
import java.util.LinkedList;
import java.util.Stack;

public class TreeDemo1 {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(3);
        linkedList.addLast(2);
        linkedList.addLast(9);
        linkedList.addLast(null);
        linkedList.addLast(null);
        linkedList.addLast(10);
        linkedList.addLast(null);
        linkedList.addLast(null);
        linkedList.addLast(8);
        linkedList.addLast(null);
        linkedList.addLast(4);

        TreeDemo1 treeDemo1 = new TreeDemo1();
        TreeNode treeNode = treeDemo1.buildTree(linkedList);

        //        treeDemo1.recursionTree(treeNode);
        //        treeDemo1.preOrder(treeNode);
        //        treeDemo1.preOrderByStack(treeNode);

        //        treeDemo1.inOrderByRecursion(treeNode);
        //        treeDemo1.inOrderByStack(treeNode);

        //        treeDemo1.postOrderByRecursion(treeNode);
        treeDemo1.postOrderByStack(treeNode);
        // todo linkedList
    }

    /**
     * 后序遍历需要加入上个访问节点
     *
     * @param treeNode
     */
    private void postOrderByStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }

            TreeNode node = stack.peek();
            if (node.getLeft() == null) {
                System.out.println("null");
            }
            if (node.getRight() == null) {
                System.out.println("null");
            }

            if (node.getRight() == null || prev == node.getRight()) {

                stack.pop();
                System.out.println(node.getData());
                prev = node;
            } else {
                treeNode = node.getRight();
            }
        }
    }

    // 递归后序遍历
    private void postOrderByRecursion(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.println("null");
            return;
        }

        postOrderByRecursion(treeNode.getLeft());
        postOrderByRecursion(treeNode.getRight());
        System.out.println(treeNode.getData());
    }

    private void inOrderByStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        //        stack.push(treeNode);

        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }

            TreeNode node = stack.pop();
            if (node.getLeft() == null) {
                System.out.println("null");
            }
            System.out.println(node.getData());

            if (node.getRight() == null) {
                System.out.println("null");
            }

            treeNode = node.getRight();
        }
    }

    private void inOrderByRecursion(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.println("null");
            return;
        }

        inOrderByRecursion(treeNode.getLeft());
        System.out.println(treeNode.getData());
        inOrderByRecursion(treeNode.getRight());
    }

    private void recursionTree(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.println("null");
            return;
        }

        System.out.println(treeNode.getData());
        recursionTree(treeNode.getLeft());
        recursionTree(treeNode.getRight());
    }

    private void preOrder(TreeNode treeNode) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(treeNode);
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.removeFirst();
            if (node == null) {
                System.out.println("null");
                continue;
            }
            System.out.println(node.getData());
            linkedList.addFirst(node.getRight());
            linkedList.addFirst(node.getLeft());
        }
    }

    private void preOrderByStack(TreeNode treeNode) {
        Stack<TreeNode> treeNodeStack = new Stack<>();

        treeNodeStack.push(treeNode);

        while (!treeNodeStack.empty()) {
            TreeNode node = treeNodeStack.pop();
            if (node == null) {
                System.out.println("null");
                continue;
            }

            System.out.println(node.getData());
            treeNodeStack.push(node.getRight());
            treeNodeStack.push(node.getLeft());
        }
    }

    public TreeNode buildTree(LinkedList<Integer> linkedList) {

        if (linkedList == null || linkedList.isEmpty()) return null;

        Integer integer = linkedList.removeFirst();

        if (integer == null) return null;

        TreeNode left = buildTree(linkedList);
        TreeNode right = buildTree(linkedList);

        return new TreeNode(left, right, integer);
    }
}
