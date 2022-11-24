package day.day04;

public class MyQueue {

    private int[] array = new int[6];
    private int front;
    private int rear;

    public void enQueue(int element) {
        if (rear + 1 % array.length == front) {
            throw new RuntimeException("队列已满");
        }

        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    public int deQueue() {
        if (front == rear) {
            throw new RuntimeException("队列已经清空");
        }
        int data = array[front];
        front = (front + 1) % array.length;
        return data;
    }

    public void output() {
        // 考虑到队尾可能比队首要大，并且是可循环数组，因此i取值需要进行数组长度取余
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.print(array[i]);
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enQueue(3);
        myQueue.enQueue(5);
        myQueue.enQueue(6);
        myQueue.enQueue(8);
        myQueue.enQueue(1);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.enQueue(2);
        myQueue.enQueue(4);
        myQueue.enQueue(9);
        myQueue.output();
    }
}
