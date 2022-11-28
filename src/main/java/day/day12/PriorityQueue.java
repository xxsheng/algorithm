package day.day12;

import java.util.Arrays;

public class PriorityQueue {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        priorityQueue.enQueue(7);
        priorityQueue.enQueue(1);
        priorityQueue.enQueue(1);
        priorityQueue.enQueue(8);
        priorityQueue.enQueue(4);
        priorityQueue.enQueue(4);
        System.out.println("出队元素" + priorityQueue.deQueue());
        System.out.println("出队元素" + priorityQueue.deQueue());
        System.out.println("出队元素" + priorityQueue.deQueue());
        System.out.println("出队元素" + priorityQueue.deQueue());
        System.out.println("出队元素" + priorityQueue.deQueue());
        System.out.println("出队元素" + priorityQueue.deQueue());
        System.out.println("出队元素" + priorityQueue.deQueue());
        System.out.println("出队元素" + priorityQueue.deQueue());
        System.out.println("出队元素" + priorityQueue.deQueue());
    }

    int[] array = new int[10];
    int size = 0;

    void enQueue(int data) {
        if (size == array.length) {
            resize();
        }
        size++;
        upAdjust(data);
    }

    int deQueue() {
        int popData = array[0];
        downAdjust(array[size - 1]);

        size--;
        return popData;
    }

    private void downAdjust(int rootData) {
        int parentIndex = 0;
        int childIndex = 2 * parentIndex + 1;

        while (childIndex < size - 1) {
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            if (array[childIndex] > rootData) {
                array[parentIndex] = array[childIndex];
                parentIndex = childIndex;
                childIndex = 2 * parentIndex + 1;
            } else {
                break;
            }
        }

        array[parentIndex] = rootData;
    }

    private void upAdjust(int data) {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0 && array[parentIndex] < data) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }

        array[childIndex] = data;
    }

    private void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }
}
