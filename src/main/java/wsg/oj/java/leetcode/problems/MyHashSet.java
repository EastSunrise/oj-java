package wsg.oj.java.leetcode.problems;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author Kingen
 */
public class MyHashSet {

    private BitSet hashSet;
    private BitSet[] keySet;
    private static final int CAPACITY = 10001;
    private static final int BASE = 100;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        hashSet = new BitSet(CAPACITY);
        keySet = new BitSet[CAPACITY];
        Arrays.fill(keySet, new BitSet(BASE));
    }

    public void add(int key) {
        int hash = hash(key);
        hashSet.set(hash);
        keySet[hash].set(key % 100);
    }

    public void remove(int key) {
        int hash = hash(key);
        if (hashSet.get(hash)) {
            keySet[hash].clear(key % 100);
            if (keySet[hash].isEmpty())
                hashSet.clear(hash);
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = hash(key);
        return hashSet.get(hash) && keySet[hash].get(key % 100);
    }

    private int hash(int key) {
        return key / BASE;
    }
}
