package algorithm;

public class LinkedList {
    // 头节点指针
    private Node head;
    // 尾节点指针
    private Node last;
    // 链表实际长度
    private int size;

    private static class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }

    /*
    * 链表插入元素
    * @param data 插入元素
    * @param index 插入位置
    * */

    public void insert(int data, int index) throws Exception {
        if (index <0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node insertedNode = new Node(data);
        if (size == 0) {
            // 空链表
            head = insertedNode;
            last = insertedNode;
        } else if(index == 0) {
            insertedNode.next = head;
            head = insertedNode;
        } else if (size == index ) {
            Node node = get(index - 1);
            node.next = insertedNode;
            last = insertedNode;
        } else {
            // 插入中间
            Node prevNode = get(index - 1);
            insertedNode.next = prevNode.next;
            prevNode.next = insertedNode;
        }

        size ++;
    }

    /*
    * 查找元素
    *
    * */
    public Node get(int index) throws Exception{
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    /*
    * 删除元素
    *
    * */

    public Node delete(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node removeNode = null;
        if (index == 0) {
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            // 删除尾节点
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            // 删除中间节点
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            removeNode.next = null;
            prevNode.next = nextNode;

        }

        size --;
        return removeNode;
    }

    public void outPut() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(3, 0);
        linkedList.insert(7, 1);
        linkedList.insert(9, 2);
        linkedList.insert(5, 3);
        linkedList.insert(6, 1);
        linkedList.delete(0);
        linkedList.outPut();

    }
}
