package day.day07;

public class Demo3 {
    int[] array = new int[10];

    int front;
    int rear;

    public void enQueue(int data) {

        if (front + 1 % array.length == front) {
            throw new IndexOutOfBoundsException("队列已满");
        }
        if (front == rear && front == 0) {
            array[front] = data;
        } else {
            array[rear] = data;
            rear = rear + 1 % array.length;
        }
    }

    public int deQueue() {
        if (rear == front) throw new IndexOutOfBoundsException("队列已空");
        int data = array[front];
        front = front + 1 % array.length;
        return data;
    }
}
