package algorithm;

public class ListNodeReverseMerged {

    public static void main(String[] args) {
        // 节点长度
        int n  = Integer.parseInt(args [0]);
        // 临时节点
        ListNode node = new ListNode(0);
        node = crateLisNode(n, node);

        int midIndex = (n%2 == 0) ? (n/2) : (n/2 + 1);
        ListNode midNode = node;

        // 找出中间节点
        for (int i = 1; i <= midIndex - 1; i++) {
            midNode = midNode.next;
        }
        // 递归反转
        ListNode reversedNode = diguiReverseNode(midNode);

        // 合并链表
        ListNode mergedNode = mergeNode(node, reversedNode);
        while (mergedNode != null) {
            System.out.println(mergedNode.value);
            mergedNode = mergedNode.next;
        }
    }

    private static ListNode mergeNode(ListNode node, ListNode reversedNode) {
        // 保存头节点
        ListNode head = node;
        while (node != null && reversedNode != null) {
            if (node == reversedNode) { // 遍历结束
                return head;
            }
            // 下一个节点
            ListNode next = node.next;
            // 反转链表的下一个节点
            ListNode next1 = reversedNode.next;
            // 将原始链表下一节点设置为反转后链表的头部节点
            node.next = reversedNode;
            // 拿到反转链表的下一节点
            reversedNode.next = next;
            // 更改遍历原始链表的指针位置
            node = next;
            // 更改遍历反转链表的指针位置
            reversedNode = next1;

        }
        // 返回head
        return head;
    }

    // 1->2->3->4->5->6
    // 1<-2<-3
    private static ListNode reverseNode(ListNode midNode) {
        // 前一节点默认为null
        ListNode pre =null;

        while (midNode != null) {
            // 暂存当前节点下一节点用来更改指针位置
            ListNode next = midNode.next;
            // 当前节点下一节点默认为前一节点
            midNode.next = pre;
            // 前一节点默认为当前遍历节点
            pre = midNode;
            // 更改遍历节点的指针位置
            midNode = next;
        }

        return pre;

    }

    private static ListNode diguiReverseNode(ListNode midNode) {

        // 表示最后节点
        if (midNode == null || midNode.next == null) {
            return midNode;
        }
        // 保留上一个递归的现场指针，后一节点
        ListNode temp = midNode.next;
        // 始终返回head节点
        ListNode newHead = diguiReverseNode(midNode.next);
        /**
         * 1、新增后节点指针指向前节点，并且设置前节点到后节点的指针为null
         */
        temp.next = midNode;
        midNode.next = null;

        // 始终返回新的头节点
        return newHead;
    }

    private static ListNode crateLisNode(int n, ListNode node) {
        ListNode temp = node;
        for (int i = 1; i <= n; i++) {
            ListNode listNode = new ListNode(i);
            node.setNext(listNode);
            node = listNode;
        }
        // 获取链表实际第一个节点
        return temp.next;
    }
}


class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

}
