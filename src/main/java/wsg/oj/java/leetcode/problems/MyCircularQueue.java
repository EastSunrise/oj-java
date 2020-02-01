package wsg.oj.java.leetcode.problems;

/**
 * @author Kingen
 */
public class MyCircularQueue {
    private int[] data;
    private int capacity;
    private int length;
    private int front;
    private int rear;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        capacity = k;
        data = new int[k];
        length = front = rear = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (capacity == length)
            return false;
        data[rear] = value;
        rear = (rear + 1) % capacity;
        length++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (length == 0)
            return false;
        front = (front + 1) % capacity;
        length--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (length == 0)
            return -1;
        else
            return data[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (length == 0)
            return -1;
        else
            return data[(rear + capacity - 1) % capacity];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return length == capacity;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.Rear();
        queue.isFull();
        queue.deQueue();
        queue.enQueue(4);
        queue.Rear();
    }
}
