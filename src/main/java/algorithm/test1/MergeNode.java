package algorithm.test1;

public class MergeNode {

    static ListNode A = new ListNode(0);
    static ListNode B = new ListNode(1);
    static ListNode C = new ListNode(2);
    static {
        A.next = new ListNode(1);
        A.next.next = new ListNode(20);
        A.next.next.next = new ListNode(21);
        A.next.next.next.next = new ListNode(22);
//        A.next.next.next.next.next = new ListNode(5);
//        A.next.next.next.next.next.next = new ListNode(6);
//        A.next.next.next.next.next.next.next = new ListNode(7);
//        A.next.next.next.next.next.next.next.next = new ListNode(8);


        B.next = new ListNode(4);
        B.next.next = new ListNode(5);
        B.next.next.next = new ListNode(7);
        B.next.next.next.next = new ListNode(8);
        B.next.next.next.next.next = new ListNode(9);
        B.next.next.next.next.next.next = new ListNode(10);
        B.next.next.next.next.next.next.next = new ListNode(11);
        B.next.next.next.next.next.next.next.next = new ListNode(12);
    }

    public static void main(String[] args) {
        ListNode listNode = diguiReverse(A, B);
//        ListNode head = C;
//        while (A != null && B != null) {
//            if (A.value < B.value) {
//                C.next = A;
//                A = A.next;
//            } else {
//                C.next = B;
//                B = B.next;
//            }
//            C = C.next;
//        }
//
//        if (A == null && B != null) {
//            C.next = B;
//        } else if (A != null) {
//            C.next = A;
//        }
//        C = head.next;
//
        while (listNode != null) {
            System.out.println(listNode.value);
            if (listNode.next == null) break;
            listNode = listNode.next;
        }
    }

    static ListNode diguiReverse(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }

        if (l1.value < l2.value) {
            l1.next = diguiReverse(l1.next, l2);
            return l1;
        } else {
            l2.next = diguiReverse(l1, l2.next);
            return l2;
        }


    }
}

class ListNode {
    ListNode next;
    int value;

    ListNode(int value) {
        this.value = value;
    }
}
