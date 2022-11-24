package day.day10;

public class Demo2 {

    Node head;
    Node last;

    // 构造链表
    void buildList1() {
        head = new Node(1, null);
        head.setNext(new Node(1, new Node(1, new Node(8, null))));
    }
    // 构造链表
    void buildList2() {
        head = new Node(1, null);
        head.setNext(
                new Node(2, new Node(3, new Node(3, new Node(4, new Node(4, new Node(5, null)))))));
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        demo2.deleteDuplicateNode();
    }
    // -1 1 1 1 8
    public void deleteDuplicateNode() {
        // 构造链表
        buildList2();

        // 首先定义一个不会和head相同的节点的值作为头节点
        Node node = new Node(-1, head);

        // 指针1，永远不会包含重复元素的一个指针，也是当前元素正确的指针
        Node point1 = node;

        // 指针2，移动的指针，这个指针在不同情况下可能不一样
        Node point2 = point1.next;

        while (point2 != null) {
            Node next = point2.next;
            if (next != null) {

                if (point2.getData() == next.getData()) {
                    Node next1 = next.next;
                    if (next1 == null) {
                        point1.next = null;
                        break;
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
