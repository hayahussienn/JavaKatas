package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularBufferTest
{
    // Test general functionality of adding, retrieving, and checking the buffer's state
    @Test
    public void testCircularBuffer()
    {
        CircularBuffer buffer = new CircularBuffer(4);

        buffer.add(4);
        buffer.add(5);
        buffer.add(6);
        buffer.add(7);
        assertEquals(buffer.get(),4);
        buffer.add(8);
        assertEquals(buffer.get(),5);
        buffer.add(9);
        assertTrue(buffer.isFull());
        assertEquals(buffer.get(),6);
        assertFalse(buffer.isFull());
        assertFalse(buffer.isEmpty());

    }

    // Test behavior of an empty buffer
    @Test
    public void testEmptyCircularBuffer()
    {
        CircularBuffer buffer = new CircularBuffer(4);
        assertTrue(buffer.isEmpty());
        assertEquals(buffer.get(),-1);
    }

    // Test behavior of a full buffer and overwriting the oldest value
    @Test
    public void testFullCircularBuffer()
    {
        CircularBuffer buffer = new CircularBuffer(2);
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        assertTrue(buffer.isFull());
        assertEquals(buffer.get(),2);

    }

    // Test behavior of a buffer with size 1
    @Test
    public void testBufferOfSizeOne() {
        CircularBuffer buffer = new CircularBuffer(1);
        buffer.add(10);
        assertTrue(buffer.isFull());
        assertEquals(buffer.get(), 10);
        buffer.add(20);
        assertEquals(buffer.get(), 20);
    }

    // Check that creating a buffer with a negative capacity throws an exception
    @Test
    public void testInvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CircularBuffer(-2);
        }, "Expected IllegalArgumentException for negative capacity");
    }



}
