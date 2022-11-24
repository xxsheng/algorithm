package day.day10;

// 反转链表
public class Demo1 {

    ListNode head;
    ListNode last;

    void buildListNode() {
        head = new ListNode(1, null);

        ListNode node = head;
        for (int i = 2; i < 10; i++) {
            ListNode listNode = new ListNode(i, null);
            node.setNext(listNode);
            node = listNode;
        }

        last = node;
    }

    public void reverseListNode() {
        buildListNode();
        if (head == null) {
            return;
        } else {
            ListNode last = doReverseListNode(head);
            this.last = last;
        }
    }

    private ListNode doReverseListNode(ListNode node) {
        ListNode next = node.next;
        if (next == null) {
            // 这是最后一个元素
            this.head.next = null;
            ListNode listNode = new ListNode(node.data, null);
            this.head = listNode;
            return listNode;
        }
        // next不等于null
        ListNode prevNode = doReverseListNode(next);
        prevNode.next = node;
        return node;
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        // 递归
        //        demo1.reverseListNode();
        // 非递归
        demo1.reverseListNode1();
    }

    private void reverseListNode1() {
        buildListNode();
        ListNode node = head;
        ListNode prev = null;
        this.last = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        this.head = prev;
    }

    private static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
