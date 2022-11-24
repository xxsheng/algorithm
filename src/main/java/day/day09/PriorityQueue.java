package day.day09;

import java.util.Arrays;

public class PriorityQueue {

    int[] array = new int[10];
    int size;

    public void enQueue(int data) {
        if (size == array.length) {
            resize();
        }
        // 放到最后一个位置
        array[size++] = data;
        upAdjust();
    }

    private void upAdjust() {
        int childIndex = size - 1;
        int childData = array[childIndex];
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0 && array[parentIndex] < childData) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = childData;
    }

    private int deQueue() {

        if (size == 0) {
            throw new IndexOutOfBoundsException("队列为空");
        }

        int waitPopData = array[0];
        array[0] = array[--size];

        downAdjust();

        return waitPopData;
    }

    private void downAdjust() {
        int parentIndex = 0;
        int childIndex = 1;
        int temp = array[parentIndex];

        while (childIndex < size) {
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            if (temp >= array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    private void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

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
}
