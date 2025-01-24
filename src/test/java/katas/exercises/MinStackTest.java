package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MinStackTest
{
    @Test
    void testGetMin() {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(9);
        stack.push(7);

        assertEquals(2, stack.getMin()); //Minimum value should be 2
    }

    @Test
    void testPushAndTop() {
        MinStack stack = new MinStack();
        stack.push(8);
        stack.push(9);
        stack.push(3);

        assertEquals(3, stack.top()); //Top value should be 3
    }

    @Test
    void testPopAndGetMin() {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(3);
        stack.push(6);

        assertEquals(3, stack.getMin()); // Minimum value should be 3

        stack.pop();
        assertEquals(3, stack.getMin()); // Minimum value should remain 3 after popping 6

        stack.pop();
        assertEquals(4, stack.getMin()); // Minimum value should be 4 after popping 3
    }


    @Test
    void testEmptyStackBehavior() {
        MinStack stack = new MinStack();

        assertThrows(IllegalStateException.class, stack::pop); // pop from an empty stack should throw an exception
        assertThrows(IllegalStateException.class, stack::top);  // Accessing top on an empty stack should throw an exception
        assertThrows(IllegalStateException.class, stack::getMin); //  getMin from an empty stack should throw an exception
    }

}
