package katas.exercises;

import java.util.Stack;

/**
 * Design a stack that supports standard stack operations (push, pop, top)
 * and also retrieves the minimum element in constant time.
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** Initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();   // Holds minimum values in descending order (top is the current minimum)
    }

    public void push(int val) {
        stack.push(val);
        // Push the value to minStack if it is the new minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int removedValue = stack.pop();
        // Remove from minStack if the popped value is the minimum
        if (removedValue == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin()); // Output: -3
        stack.pop();
        System.out.println(stack.top());    // Output: 0
        System.out.println(stack.getMin()); // Output: -2
    }
}
