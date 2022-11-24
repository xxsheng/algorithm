package day.day09;

public class Demo1 {
    Node head;
    Node last;
    int size;

    // 构造链表
    void buildList() {
        head = new Node(1, null);
        size++;
        Node curentNode = head;
        for (int i = 2; i < 10; i++) {
            Node node = new Node(i, null);
            curentNode.setNext(node);
            curentNode = curentNode.next;
            if (i == 9) {
                last = node;
            }
            size++;
        }
    }

    // 构造链表
    void buildList1() {
        head = new Node(1, null);
        head.setNext(new Node(1, new Node(1, new Node(8, null))));
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.reverseListNode();
        demo1.reverseListNode02();

        demo1.delteDuplicateNode();
    }

    // 反转链表
    public void reverseListNode() {
        buildList();
        if (head == null) {
            return;
        } else {
            Node node = doReverseListNode(head);
            last = node;
            System.out.println(node);
        }
    }

    // 反转链表2
    public void reverseListNode02() {
        buildList();
        Node node = head;
        Node prev = null;
        while (node != null) {
            Node next = node.next;
            // 到最后一个元素了
            node.next = prev;
            prev = node;
            node = next;
        }
        last = head;
        head = prev;
    }

    private Node doReverseListNode(Node node) {
        Node next = node.next;
        if (next == null) {
            head.next = null;
            Node head = new Node(node.data, next);
            this.head = head;
            return head;
        }
        Node node1 = doReverseListNode(next);
        node1.next = node;
        return node;
    }

    // 去除链表重复元素
    public void delteDuplicateNode() {
        buildList1();
        Node node = new Node(-1, head);
        Node point1 = node;
        Node point2 = node.next;
        while (point2 != null) {
            Node next = point2.next;
            if (next != null) {
                if (point2.getData() == next.getData()) {
                    Node next1 = next.next;
                    if (next1 == null) {
                        point1.next = next1;
                    } else {
                        if (next1.getData() == point2.getData()) {
                            point2 = next;
                        } else {
                            point1.next = next1;
                            point2 = next1;
                        }
                    }
                } else {
                    point1 = point2;
                    point2 = next;
                }
            } else {
                break;
            }
        }
        this.head = node.next;
        System.out.println(node);
    }

    private static class Node {
        Integer data;
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
