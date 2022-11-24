package day.day03;

public class MyLinkedList {

    Node head;
    Node tail;
    int size;

    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表范围");
        }

        if (size == 0) {
            Node node = new Node(data, null);
            this.head = node;
            this.tail = node;
            return;
        }
        if (index == 0) {
            this.head = new Node(data, head);
            return;
        }

        if (index == size) {
            Node newNode = new Node(data, null);
            tail.next = newNode;
            tail = newNode;
            return;
        }

        Node prev = get(index - 1);
        Node next = prev.next;
        prev.next = new Node(data, next);

        size++;
    }

    public Node get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超过链表元素个数");
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Node remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超过链表元素个数");
        }

        size--;
        if (index == 0) {
            Node head = this.head;
            this.head = this.head.next;
            head.next = null;
            return head;
        }

        if (index == size) {
            Node node = get(index - 1);
            this.tail = node;
            Node tail = node.next;
            node.next = null;
            return tail;
        }

        Node temp = get(index - 1);
        Node waitDeleteNode = temp.next;
        temp.next = waitDeleteNode.next;
        waitDeleteNode.next = null;
        return waitDeleteNode;
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
