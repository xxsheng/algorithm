package day.day07;

public class Demo2 {

    Node head;
    Node last;
    int size;

    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表长度");
        }
        if (size == 0) {
            Node node = new Node(data, null);
            head = node;
            last = node;
        } else if (size == index) {
            Node node = new Node(data, null);
            last.next = node;
            last = node;
        } else if (index == 0) {
            head = new Node(data, head);
        } else {
            Node node = get(index - 1);
            Node next = node.next;
            node.next = new Node(data, next);
        }
    }

    public Node get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表长度");
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Node delete(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表长度");
        }
        Node deleteNode = null;
        if (index == 0) {
            deleteNode = this.head;
            this.head = this.head.next;
        } else if (index == size - 1) {
            deleteNode = last;
            Node node = get(index - 1);
            last = node;
            node.next = null;
        } else {

            Node node = get(index - 1);
            deleteNode = node.next;
            node.next = deleteNode.next;
            deleteNode.next = null;
        }
        return deleteNode;
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
