package day.day17;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(Integer number) {
        stack1.push(number);
        if (stack2.isEmpty() || stack2.peek() >= number) {
            stack2.push(number);
        }
    }

    public int pop() {
        Integer number = stack1.pop();
        if (number.equals(stack2.peek())) {
            stack2.pop();
        }

        return number;
    }

    public int getMin() throws Exception {
        if (stack1.isEmpty()) {
            throw new Exception("stack is empty");
        }
        return stack2.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(9);
        minStack.push(7);
        minStack.push(3);
        minStack.push(8);
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
