package wsg.oj.java.solution;

import java.util.Arrays;

/**
 * @author Kingen
 */
public class MyHashMap {

    private int[] keys;

    private int[] values;

    private int size;

    private int capacity;

    private static final int MAX_SIZE = 10000;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        size = 0;
        capacity = 1;
        keys = new int[capacity];
        values = new int[capacity];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i]) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size++] = value;
        if (size == capacity) {
            capacity *= 2;
            keys = Arrays.copyOf(keys, capacity);
            values = Arrays.copyOf(values, capacity);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i]) {
                return values[i];
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i]) {
                keys[i] = keys[size - 1];
                values[i] = values[--size];
            }
        }
    }
}
