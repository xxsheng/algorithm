package day.day31;

public class Demo2 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        addTwoNumbers(listNode, listNode2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode temp = newNode;
        int tempData = 0;
        while (l1 != null || l2 != null) {
            int l1Temp = l1 == null ? 0 : l1.val;
            int l2Temp = l2 == null ? 0 : l2.val;
            int data = l1Temp + l2Temp + tempData;
            tempData = data / 10;
            data = data % 10;

            newNode.next = new ListNode(data);

            l1 = l1 == null ? null : l1.next;

            l2 = l2 == null ? null : l2.next;
            newNode = newNode.next;
        }
        if (tempData == 1) {
            newNode.next = new ListNode(1);
        }

        return temp.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
