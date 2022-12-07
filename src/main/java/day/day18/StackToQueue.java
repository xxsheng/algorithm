package day.day18;

import java.util.Stack;

public class StackToQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void add(int number) {
        stack1.push(number);
    }

    public int peek() throws Exception {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new Exception("队列为空");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public int deQueue() throws Exception {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new Exception("队列为空");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) throws Exception {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.add(1);
        stackToQueue.add(2);
        stackToQueue.add(3);
        stackToQueue.add(4);
        System.out.println(stackToQueue.deQueue());
        System.out.println(stackToQueue.deQueue());
        System.out.println(stackToQueue.deQueue());
        System.out.println(stackToQueue.deQueue());
        System.out.println(stackToQueue.deQueue());
    }
}
