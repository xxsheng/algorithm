package algorithm;

public class Array {

    private int[] array;
    private int front;
    private int rear;

    public Array(int capacity) {
        this.array = new int[capacity];
    }

    /*
    * 入队
    * @param element 入队的元素
    * */
    public void enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满");

        }
        array[rear] = element;
        rear = (rear +1) % array.length;
    }

    /*
    * 出队
    * */
    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空！");
        }

        int deQueueElemet = array[front];
        front = (front + 1) % array.length;
        return deQueueElemet;
    }

    /*
    * 输出队列
    * */
    public void outPut() {
        for (int i = front; i!=rear; i = (i+1) % array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Array array = new Array(6);
        array.enQueue(3);
        array.enQueue(5);
        array.enQueue(6);
        array.enQueue(8);
        array.enQueue(1);
        array.deQueue();
        array.deQueue();
        array.deQueue();
        array.enQueue(2);
        array.enQueue(4);
        array.enQueue(9);
        array.outPut();
    }
}
