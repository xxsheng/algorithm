package day.day19;

import java.util.Stack;

public class Demo5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int num) {
        stack1.push(num);

        if (num < stack2.peek()) {
            stack2.push(num);
        }
    }

    public int pop() throws Exception {
        if (stack1.isEmpty()) {
            throw new Exception("队列已空");
        }

        Integer pop = stack1.pop();

        if (pop.equals(stack2.peek())) {
            stack2.pop();
        }

        return pop;
    }

    public int getMin() throws Exception {
        if (stack1.isEmpty()) {
            throw new Exception("队列已空");
        }
        return stack2.peek();
    }
}
