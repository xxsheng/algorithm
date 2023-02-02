package day.day29;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<String, Node> map = new HashMap<>();

    Node head;
    Node tail;
    int size;

    public String get(String key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        } else {
            refresh(node);
            return node.getValue();
        }
    }

    public void put(String key, String value) {
        Node node = map.get(key);
        if (node != null) {
            node.setValue(value);
            refresh(node);
        } else {
            Node node1 = new Node();
            node1.setKey(key);
            node1.setValue(value);
            if (map.size() >= size) {

                map.remove(head.getKey());
                remove(head);
            }
            map.put(key, node1);
            add(node1);
        }
    }

    private void refresh(Node node) {
        if (size > 1 && node != tail) {
            // remove

            remove(node);
            // add
            add(node);
        }
    }

    private void add(Node node) {
        if (head == tail && head == null) {
            head = node;
            tail = node;
            head.next = tail;
            tail.prev = head;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    private void remove(Node node) {
        if (head != null && head == tail) {
            head = null;
            tail = null;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else if (node == head) {
            head = head.next;
            head.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private static class Node {
        String key;
        String value;
        Node prev;
        Node next;

        public Node() {}

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

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
