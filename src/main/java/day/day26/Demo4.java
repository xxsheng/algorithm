package day.day26;

import java.util.Stack;

public class Demo4 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void enQueue(Integer num) {
        stack1.push(num);
    }

    public void deQueue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("队列已空");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }
}
