package katas.exercises;

public class  CircularBuffer {
    /**
     * Design a circular buffer (ring buffer).
     *
     * The buffer should operate in constant time.
     * When the buffer is full, adding a new element should overwrite the oldest element.
     *
     */


    private int[] buffer;
    private int head;
    private int tail;
    private int size;

    /**
     * Initializes the circular buffer with a fixed capacity.
     *
     * @param capacity the maximum number of elements the buffer can hold
     */
    public CircularBuffer(int capacity)
    {
        if (capacity <= 0)
        {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        buffer=new  int[capacity];  // Creates the array with given capacity
        head=0; // It's like a bookmark that shows where to READ from
        tail=0; //It's like a pen that shows where to WRITE next
        size=0; // Buffer starts empty

    }

    /**
     * Adds an element to the buffer.
     *
     * @param val the value to add
     */
    public void add(int val)
    {
        buffer[tail] = val;  // Write the new value at the tail
        tail = (tail + 1) % buffer.length; // Move the tail forward in a circular manner

        if (size < buffer.length)
        {
            size++; // Increase size if buffer is not yet full
        } else
        {
            head = (head + 1) % buffer.length; // Overwrite the oldest element if full
        }
    }

    /**
     * Retrieves the oldest element from the buffer.
     *
     * @return the oldest element, or -1 if the buffer is empty
     */
    public int get()
    {

        if (isEmpty())
        {
            return -1;  // if the buffer is empty return -1
        }
        int getValue = buffer[head];   // Retrieve the oldest value from the buffer
        head = (head + 1) % buffer.length;  // Move the head pointer forward in a circular manner
        size-=1; // Decrease the size of the buffer
        return  getValue;

    }

    /**
     * Checks if the buffer is full.
     *
     * @return true if the buffer is full, false otherwise
     */
    public boolean isFull()
    {
       return size==buffer.length ;

    }

    /**
     * Checks if the buffer is empty.
     *
     * @return true if the buffer is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return size==0;

    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        System.out.println(buffer.get()); // Output: 1
        buffer.add(4);
        System.out.println(buffer.get()); // Output: 2
        buffer.add(5);
        System.out.println(buffer.isFull()); // Output: true
    }
}


