package day.day12;

public class DuplicateNode {

    Node head;

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
        DuplicateNode duplicateNode = new DuplicateNode();
        duplicateNode.buildList2();
        duplicateNode.deleteDuplicateNode();
    }

    void deleteDuplicateNode() {
        Node node = new Node(-1, head);

        Node point1 = node;
        Node point2 = node.next;

        while (point2 != null) {
            Node next1 = point2.next;
            if (next1 == null) {
                break;
            } else {
                if (next1.getData() == point2.getData()) {
                    Node next2 = next1.next;
                    if (next2 == null) {
                        point1.next = null;
                    } else {
                        if (next2.getData() == point2.getData()) {
                            point2 = next1;
                        } else {
                            point1.next = next2;
                            point2 = next2;
                        }
                    }
                } else {
                    point1 = point2;
                    point2 = next1;
                }
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
