package day.day06;

import day.day04.TreeDemo1.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        LinkedList<Integer> clone = (LinkedList<Integer>) linkedList.clone();
        TreeNode tree = buildTree(linkedList);
        TreeNode tree1 = buildTree1(clone);

        TreeDemo1 treeDemo1 = new TreeDemo1();

        // 中序遍历
        System.out.println("中序遍历");
        // 链表
        treeDemo1.inOrderByLinkedList(tree);
        System.out.println();
        // 栈
        treeDemo1.inOrderByStack(tree);
        System.out.println();
        // 递归
        treeDemo1.inOrderByRecursion(tree);

        System.out.println();
        System.out.println("后序遍历");
        // 后序遍历 null null 9 null null 10 2 null null null 4 8 3
        // 递归
        treeDemo1.postOrderByRecursion(tree);
        // 链表
        System.out.println();
        treeDemo1.postOrderByLinkedList(tree);
        // 栈
        System.out.println();
        treeDemo1.postOrderByStack(tree);

        // 前序遍历 3 2 9 null null 10 null null 8 null 4 null null
        System.out.println();
        System.out.println("前序遍历");
        // 递归
        treeDemo1.preOrderByRecursion(tree);
        System.out.println();
        // 栈
        treeDemo1.preOrderByStack(tree);
        System.out.println();
        // 链表
        treeDemo1.preOrderByLinkedList(tree);
        // 简单方式
        System.out.println();
        treeDemo1.preOrderBySimple(tree);

        // 层序遍历 3 2 8 9 10 null 4 null null null null
        System.out.println();
        System.out.println("层序遍历");
        // 队列
        System.out.println();
        treeDemo1.levelOrderByLinkedList(tree);
        // 递归
        System.out.println();
        List<List<Integer>> levelList = new ArrayList<>();
        treeDemo1.levelOrderByRecursion(tree, 0, levelList);
        System.out.println(levelList);
    }

    private static TreeNode buildTree1(LinkedList<Integer> linkedList) {

        if (!linkedList.isEmpty()) {
            Integer data = linkedList.removeFirst();
            if (data == null) return null;
            TreeNode left = buildTree1(linkedList);
            TreeNode right = buildTree1(linkedList);
            return new TreeNode(left, right, data);
        }
        return null;
    }

    private void levelOrderByRecursion(
            TreeNode tree, Integer level, List<List<Integer>> levelList) {

        if (tree == null && level == levelList.size()) {
            return;
        }

        if (level >= levelList.size() && tree != null) {
            levelList.add(new ArrayList<>());
        }

        List<Integer> integers = levelList.get(level);
        if (tree == null) {
            integers.add(null);
            return;
        }
        integers.add(tree.getData());
        levelOrderByRecursion(tree.getLeft(), level + 1, levelList);
        levelOrderByRecursion(tree.getRight(), level + 1, levelList);
    }

    private void levelOrderByLinkedList(TreeNode tree) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(tree);
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.pop();
            if (node == null) {
                System.out.print("null");
                continue;
            }
            System.out.print(node.getData());
            if (node.getLeft() == null && node.getRight() == null) {

            } else {

                linkedList.addLast(node.getLeft());
                linkedList.addLast(node.getRight());
            }
        }
    }

    private void preOrderBySimple(TreeNode tree) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(tree);

        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.pop();
            if (node == null) {
                System.out.print("null");
                continue;
            }
            System.out.print(node.getData());
            linkedList.addFirst(node.getRight());
            linkedList.addFirst(node.getLeft());
        }
    }

    private void preOrderByLinkedList(TreeNode tree) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        while (!linkedList.isEmpty() || tree != null) {
            while (tree != null) {
                linkedList.addFirst(tree);
                System.out.print(tree.getData());
                tree = tree.getLeft();
            }

            TreeNode pop = linkedList.pop();
            if (pop.getLeft() == null) {
                System.out.print("null");
            }

            tree = pop.getRight();
            if (pop.getRight() == null) {
                System.out.print("null");
            }
        }
    }

    private void preOrderByStack(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || tree != null) {
            while (tree != null) {
                stack.push(tree);
                System.out.print(tree.getData());
                tree = tree.getLeft();
            }

            TreeNode peek = stack.pop();
            if (peek.getLeft() == null) {
                System.out.print("null");
            }

            tree = peek.getRight();
            if (peek.getRight() == null) {
                System.out.print("null");
            }
        }
    }

    private void preOrderByRecursion(TreeNode tree) {
        if (tree == null) {
            System.out.print("null");
            return;
        }

        System.out.print(tree.getData());
        preOrderByRecursion(tree.getLeft());
        preOrderByRecursion(tree.getRight());
    }

    private void postOrderByStack(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = tree;
        //        TreeNode left = tree;
        while (!stack.isEmpty() || tree != null) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.getLeft();
            }

            TreeNode node = stack.peek();
            if (node.getRight() != prev && node.getLeft() == null) {
                System.out.print("null");
            }

            //            left = node;
            if (node.getRight() == null || prev == node.getRight()) {
                stack.pop();
                if (node.getRight() == null) {
                    System.out.print("null");
                }
                System.out.print(node.getData());
                prev = node;
            } else {
                tree = node.getRight();
            }
        }
    }

    private void postOrderByLinkedList(TreeNode tree) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        TreeNode prev = null;
        TreeNode left = tree;
        while (!linkedList.isEmpty() || tree != null) {
            while (tree != null) {
                linkedList.addFirst(tree);
                tree = tree.getLeft();
            }

            TreeNode node = linkedList.peek();
            if (left != prev && node.getLeft() == null) {
                System.out.print("null");
            }
            left = node;

            if (node.getRight() == null || prev == node.getRight()) {

                TreeNode pop = linkedList.pop();

                if (pop.getRight() == null) {
                    System.out.print("null");
                }
                prev = node;
                System.out.print(node.getData());
            } else {
                tree = node.getRight();
            }
        }
    }

    // 左右根
    private void postOrderByRecursion(TreeNode tree) {
        if (tree == null) {
            System.out.print("null");
            return;
        }

        postOrderByRecursion(tree.getLeft());
        postOrderByRecursion(tree.getRight());

        System.out.print(tree.getData());
    }

    private void inOrderByRecursion(TreeNode tree) {
        if (tree == null) {
            return;
        }

        inOrderByLinkedList(tree.getLeft());
        if (tree.getLeft() == null) {
            System.out.print("null");
        }
        System.out.print(tree.getData());
        if (tree.getRight() == null) {
            System.out.print("null");
        }
        inOrderByLinkedList(tree.getRight());
    }

    private void inOrderByStack(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || tree != null) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.getLeft();
            }

            TreeNode node = stack.pop();
            // 左节点为null
            if (node.getLeft() == null) {
                System.out.print("null");
            }
            System.out.print(node.getData());
            tree = node.getRight();
            if (node.getRight() == null) {
                System.out.print("null");
            }
        }
    }

    private void inOrderByLinkedList(TreeNode treeNode) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        while (!linkedList.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                linkedList.addFirst(treeNode);
                treeNode = treeNode.getLeft();
            }

            // root
            TreeNode node = linkedList.removeFirst();
            // 左节点为null
            if (node.getLeft() == null) {
                System.out.print("null");
            }
            System.out.print(node.getData());
            treeNode = node.getRight();
            if (node.getRight() == null) {
                System.out.print("null");
            }
        }
    }

    private static TreeNode buildTree(LinkedList<Integer> linkedList) {
        if (linkedList != null && !linkedList.isEmpty()) {
            Integer integer = linkedList.removeFirst();

            if (integer == null) return null;

            TreeNode left = buildTree(linkedList);
            TreeNode right = buildTree(linkedList);

            return new TreeNode(left, right, integer);
        }

        return null;
    }
}
