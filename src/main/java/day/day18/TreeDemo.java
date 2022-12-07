package day.day18;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeDemo {

    TreeNode buildTree(LinkedList<Integer> linkedList) {
        if (linkedList.isEmpty()) {
            return null;
        }
        Integer integer = linkedList.removeFirst();
        if (integer == null) {
            return null;
        }

        TreeNode left = buildTree(linkedList);
        TreeNode right = buildTree(linkedList);
        return new TreeNode(integer, left, right);
    }

    public static void main(String[] args) {
        TreeDemo treeDemo = new TreeDemo();
        Integer[] array = {1, 3, 9, null, null, 10, null, null, 8, null, 4};
        TreeNode treeNode = treeDemo.buildTree(new LinkedList<Integer>(Arrays.asList(array)));

        // 前序遍历
        System.out.println("前序遍历");
        System.out.println("前序遍历-递归");
        treeDemo.preOrder(treeNode);
        System.out.println();
        System.out.println("前序遍历-非递归");
        treeDemo.preOrderByStack(treeNode);

        // 中序遍历
        System.out.println();
        System.out.println("中序遍历");
        System.out.println("中序遍历-递归");
        treeDemo.inOrder(treeNode);
        System.out.println();
        System.out.println("中序遍历-非递归");
        treeDemo.inOrderByStack(treeNode);

        // 后序遍历
        System.out.println();
        System.out.println("后序遍历");
        System.out.println("后序遍历-递归");
        treeDemo.postOrder(treeNode);
        System.out.println();
        System.out.println("后序遍历-非递归");
        treeDemo.postOrderByStack(treeNode);
        System.out.println();
        System.out.println("层序遍历");
        System.out.println("层序遍历-非递归");
        treeDemo.levelOrderByLinkedList(treeNode);
        System.out.println();
        System.out.println("层序遍历-递归");
        List<List<Integer>> list = new ArrayList<>();
        treeDemo.levelOrder(treeNode, 0, list);
        System.out.println(list);
    }

    private void levelOrder(TreeNode treeNode, int index, List<List<Integer>> result) {
        if (index >= result.size()) {
            result.add(new ArrayList<>());
        }

        List<Integer> integers = result.get(index);
        if (treeNode == null) {
            integers.add(null);
        } else {
            integers.add(treeNode.getData());
            levelOrder(treeNode.getLeft(), index + 1, result);
            levelOrder(treeNode.getRight(), index + 1, result);
        }
    }

    private void levelOrderByLinkedList(TreeNode treeNode) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();

        treeNodes.addLast(treeNode);

        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.removeFirst();
            if (node == null) {
                System.out.print("null");
            } else {
                System.out.print(node.getData());
                treeNodes.addLast(node.getLeft());
                treeNodes.addLast(node.getRight());
            }
        }
    }

    private void postOrderByStack(TreeNode treeNode) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode prev = treeNode;
        while (!stack.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            TreeNode node = stack.peek();
            if (prev != node.getRight() && node.getLeft() == null) {
                System.out.print("null");
            }

            if (node.getRight() == null || node.getRight() == prev) {
                if (node.getRight() == null) {
                    System.out.print("null");
                }
                TreeNode pop = stack.pop();
                System.out.print(pop.getData());
                prev = node;
            } else {
                treeNode = node.right;
            }
        }
    }

    private void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print("null");
            return;
        }

        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.print(treeNode.getData());
    }

    private void inOrderByStack(TreeNode treeNode) {
        Deque<TreeNode> stack = new ArrayDeque<>();

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

    private void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print("null");
            return;
        }

        inOrder(treeNode.left);
        System.out.print(treeNode.getData());
        inOrder(treeNode.right);
    }

    private void preOrderByStack(TreeNode treeNode) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                System.out.print(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            TreeNode node = stack.pop();
            if (node.getLeft() == null) {
                System.out.print("null");
            }

            if (node.getRight() == null) {
                System.out.print("null");
            } else {
                treeNode = node.right;
            }
        }
    }

    private void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print("null");
            return;
        }

        System.out.print(treeNode.data);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
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
