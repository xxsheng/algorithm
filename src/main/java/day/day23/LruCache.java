package day.day23;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

    Node head;
    Node tail;

    Map<String, Node> hashMap;
    private int limit;

    public LruCache(int limit) {
        this.hashMap = new HashMap<>();
        this.limit = limit;
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        refresh(node);
        return node.getValue();
    }

    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node != null) {
            node.value = value;
            refresh(node);
        } else {
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            Node newNode = new Node(key, value);
            addNode(newNode);
            hashMap.put(key, newNode);
        }
    }

    private void refresh(Node node) {
        if (node == tail) {
            return;
        } else {
            removeNode(node);
            addNode(node);
        }
    }

    private void addNode(Node node) {
        if (head == null && null == tail) {
            head = node;
            tail = node;
            return;
        }

        if (node != null) {
            node.pre = tail;
            node.next = null;
        }
        tail.next = node;
        tail = node;
    }

    private String removeNode(Node node) {
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = head.next;
            head.pre = null;
        } else if (node == tail) {
            tail = tail.pre;
            tail.next = null;
        } else {
            Node pre = node.pre;
            pre.next = node.next;
            node.next.pre = pre;

            node.pre = null;
            node.next = null;
        }

        return node.getKey();
    }

    private static class Node {
        String key;
        String value;

        Node next;
        Node pre;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }
    }
}
