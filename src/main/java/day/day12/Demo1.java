package day.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Demo1 {

    TreeNode buildTree(LinkedList<Integer> linkedList) {
        if (linkedList.isEmpty()) {
            return null;
        }

        Integer integer = linkedList.removeFirst();
        if (integer == null) return null;
        TreeNode left = buildTree(linkedList);
        TreeNode right = buildTree(linkedList);
        return new TreeNode(integer, left, right);
    }

    public static void main(String[] args) {
        Integer[] array = {3, 2, 9, null, null, 10, null, null, 8, null, 4};
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(array));

        Demo1 demo1 = new Demo1();
        System.out.println("树的构建");
        TreeNode treeNode = demo1.buildTree(linkedList);
        // 前序遍历 3 2 9 null null 10 null null 8 null 4 null null
        System.out.println("前序遍历");
        preOrderByRecursion(treeNode);
        System.out.println();
        preOrderByLinkedList(treeNode);
        System.out.println();
        preOrderByStack(treeNode);
        System.out.println();

        // 中序遍历 null 9 null 2 null 10 null 3 null 8 null 4 null
        System.out.println("中序遍历");
        inOrderByRecursion(treeNode);
        System.out.println();
        inOrderByLinkedList(treeNode);
        System.out.println();
        inOrderByStack(treeNode);
        System.out.println();

        // 后序遍历 null null 9 null null 10 2 null null null 4 8 3
        System.out.println("后序遍历");
        postOrderByRecursion(treeNode);
        System.out.println();
        postOrderByLinkedList(treeNode);
        System.out.println();
        postOrderByStack(treeNode);
        System.out.println();

        // 层序遍历
        System.out.println("层序遍历");
        levelOrderByLinkedList(treeNode);
        System.out.println();
        List<List<Integer>> result = new ArrayList<>();
        levelOrderByRecursion(treeNode, result, 0);
        System.out.println(result.toString());

        // 根据数组构建二叉树 todo
        //        TreeNode treeNode1 = buildTreeByArray(array, 0);
        // 二叉堆

        // 列表反转

        // 删除重复链表

        // 冒泡和快排
    }

    private static TreeNode buildTreeByArray(Integer[] array, int index) {

        if (index < array.length - 1) {
            Integer integer = array[index];
            index = index + 1;
            if (integer == null) return null;
            TreeNode left = buildTreeByArray(array, index);
            TreeNode right = buildTreeByArray(array, index);

            return new TreeNode(integer, left, right);
        }
        return null;
    }

    private static void levelOrderByRecursion(
            TreeNode treeNode, List<List<Integer>> result, int index) {
        if (index > result.size()) {
            return;
        }

        if (index == result.size()) {
            List<Integer> integers = new ArrayList<>();
            result.add(integers);
        }

        List<Integer> integers = result.get(index);
        if (treeNode == null) {
            integers.add(null);
            return;
        } else {
            integers.add(treeNode.getData());
        }

        levelOrderByRecursion(treeNode.getLeft(), result, index + 1);
        levelOrderByRecursion(treeNode.getRight(), result, index + 1);
    }

    private static void levelOrderByLinkedList(TreeNode treeNode) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(treeNode);
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.removeFirst();
            if (node == null) {
                System.out.print("null");
            } else {
                System.out.print(node.getData());
                linkedList.addLast(node.getLeft());
                linkedList.addLast(node.getRight());
            }
        }
    }

    private static void postOrderByStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = treeNode;
        while ((!stack.isEmpty() || treeNode != null)) {
            while ((treeNode != null)) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            TreeNode peek = stack.peek();
            if (peek.getRight() != prev && peek.getLeft() == null) {
                System.out.print("null");
            }

            if (peek.getRight() == null || peek.getRight() == prev) {
                if (peek.getRight() == null) {
                    System.out.print("null");
                }
                TreeNode node = stack.pop();
                prev = node;
                System.out.print(node.getData());
            } else {
                treeNode = peek.getRight();
            }
        }
    }

    private static void postOrderByLinkedList(TreeNode treeNode) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        TreeNode prev = treeNode;
        while (!linkedList.isEmpty() || treeNode != null) {
            while (treeNode != null) {

                linkedList.addFirst(treeNode);
                treeNode = treeNode.left;
            }

            TreeNode peek = linkedList.peek();
            if (peek.getRight() != prev && peek.getLeft() == null) {
                System.out.print("null");
            }

            if (peek.getRight() == null || prev == peek.getRight()) {
                if (peek.getRight() == null) {
                    System.out.print("null");
                }
                TreeNode node = linkedList.pop();
                prev = node;
                System.out.print(node.getData());
            } else {
                treeNode = peek.getRight();
            }
        }
    }

    private static void postOrderByRecursion(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print("null");
            return;
        }

        postOrderByRecursion(treeNode.getLeft());
        postOrderByRecursion(treeNode.getRight());
        System.out.print(treeNode.getData());
    }

    private static void inOrderByStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            TreeNode node = stack.pop();
            if (node.getLeft() == null) {
                System.out.print("null");
            }
            System.out.print(node.getData());

            if (node.getRight() == null) {
                System.out.print("null");
            } else {
                treeNode = node.getRight();
            }
        }
    }

    private static void inOrderByLinkedList(TreeNode treeNode) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        while (!linkedList.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                linkedList.addFirst(treeNode);
                treeNode = treeNode.left;
            }

            TreeNode node = linkedList.pop();
            if (node.left == null) {
                System.out.print("null");
            }
            System.out.print(node.getData());
            if (node.getRight() == null) {
                System.out.print("null");
            } else {

                treeNode = node.right;
            }
        }
    }

    private static void inOrderByRecursion(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print("null");
            return;
        }

        inOrderByRecursion(treeNode.left);
        System.out.print(treeNode.data);
        inOrderByRecursion(treeNode.right);
    }

    private static void preOrderByStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            TreeNode node = stack.pop();
            if (node.left == null) {
                System.out.print("null");
            }

            if (node.right != null) {
                treeNode = node.right;
            } else {
                System.out.print("null");
            }
        }
    }

    private static void preOrderByLinkedList(TreeNode treeNode) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        while (!linkedList.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                System.out.print(treeNode.data);
                linkedList.addFirst(treeNode);
                treeNode = treeNode.left;
            }

            TreeNode node = linkedList.pop();
            if (node.left == null) {
                System.out.print("null");
            }
            if (node.right == null) {
                System.out.print("null");
            }

            if (node.right != null) {
                treeNode = node.right;
            }
        }
    }

    private static void preOrderByRecursion(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print("null");
            return;
        }

        System.out.print(treeNode.data);
        preOrderByRecursion(treeNode.left);
        preOrderByRecursion(treeNode.right);
    }

    private static class TreeNode {
        Integer data;
        TreeNode left;
        TreeNode right;

        public TreeNode(Integer data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
