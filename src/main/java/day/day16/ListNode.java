package day.day16;

import java.util.HashSet;
import org.junit.Test;

public class ListNode {

    Node head;
    Node tail;

    @Test
    public void test_findMidNode() {
        ListNode listNode = new ListNode();
        listNode.buildListNode();
        Node midNode = listNode.findMidNode();
        System.out.println(midNode.data);
    }

    @Test
    public void test_judge_ring_linkedList() {
        buildListNode1();
        Node node1 = head;
        HashSet<Node> hashSet = new HashSet<>();
        while (node1 != null) {
            if (!hashSet.add(node1)) {
                System.out.println(node1.getData());
                System.out.println("重复节点");
                break;
            }
            node1 = node1.next;
        }
    }

    @Test
    public void test_judge_ring_linkedList_1() {
        buildListNode1();
        Node point1 = head;
        Node point2 = head;
        Node point3 = head;
        int step = 0;
        boolean cycle = false;
        while (point2 != null && point2.next != null) {
            point1 = point1.next;
            point2 = point2.next.next;
            if (cycle) {
                step++;
                point3 = point3.next;
                if (point3 == point1) {
                    System.out.println(point3.getData());
                }
            }
            if (point1 == point2) {
                System.out.println(point1.getData());
                System.out.println("相遇节点");
                if (!cycle) {

                    cycle = true;
                } else {
                    break;
                }
            }
        }
        System.out.println(step);
    }

    public void buildListNode() {
        head = new Node(1, null);
        Node node = head;
        for (int i = 2; i <= 10; i++) {
            Node next = new Node(i, null);
            node.setNext(next);
            node = node.next;
        }
    }

    void buildListNode1() {
        head = new Node(1, null);
        Node node = head;
        Node node3 = null;
        for (int i = 2; i <= 10; i++) {
            Node next = new Node(i, null);
            node.setNext(next);
            node = node.next;
            if (i == 3) {
                node3 = node;
            }
        }
        node.next = node3;
    }

    Node findMidNode() {
        Node point1 = head;
        Node point2 = head;

        while ((point2 != null && point2.next != null)) {
            point1 = point1.next;
            point2 = point2.next.next;
        }

        return point1;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
