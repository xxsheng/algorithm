package algorithm;

public class FindMidNumber {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(new ListNode(1));
        ListNode listNode1 = deleteDuplicateNode(listNode);
        System.out.println(listNode1);
    }

    static ListNode deleteDuplicateNode(ListNode node) {
        ListNode listNode = new ListNode(-1);
        listNode.setNext(node);

        ListNode prev = listNode;
        ListNode next = node;
        while (next != null) {
            if (next.next !=null && next.value == next.next.value) {
                int value = next.value;
                while ( next !=null &&next.value == value) {
                    next = next.next;
                }
            } else {
                prev.next = next;
                prev = prev.next;
                next = next.next;
            }
            prev.next=next;
        }

        return listNode.next;
    }
}
