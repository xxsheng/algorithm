package day.day12;

public class ListNode {
    Node head;
    Node last;

    void buildListNode() {
        head = new Node(1, null);
        Node node = head;
        for (int i = 2; i < 10; i++) {
            node.setNext(new Node(i, null));
            node = node.next;
        }
        last = node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.buildListNode();

        node.reverseListNodeByRecursion();
        node.reverseListNode();
        System.out.println(node.head);
    }

    private void reverseListNode() {
        buildListNode();
        Node node = head;
        Node prev = null;
        while (node != null) {
            Node next = node.next;
            node.next = prev;
            prev = node;

            node = next;
        }

        this.last = head;
        this.head = prev;
    }

    private void reverseListNodeByRecursion() {
        Node node = doReverse(head);
        this.last = node;
    }

    private Node doReverse(Node node) {
        if (node.next == null) {
            Node newHead = new Node(node.getData(), null);
            this.head.next = null;
            this.head = newHead;
            return newHead;
        }
        Node newNode = doReverse(node.next);
        newNode.next = node;
        return node;
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
