package day.day25;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(Integer num) {
        stack1.push(num);
        Integer peek = stack2.peek();
        if (peek > num) {
            stack2.push(num);
        }
    }

    public int getMin() {
        if (stack1.isEmpty()) {
            throw new RuntimeException("栈为空");
        }

        return stack2.peek();
    }

    public int pop() {
        if (stack1.isEmpty()) {
            throw new RuntimeException("栈为空");
        }

        Integer num = stack1.pop();
        if (num.equals(stack2.peek())) {
            stack2.pop();
        }

        return num;
    }
}
