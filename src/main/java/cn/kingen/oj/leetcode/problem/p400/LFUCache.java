package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/lfu-cache/">460. LFU Cache</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.LRUCache
 * @see cn.kingen.oj.leetcode.problem.p500.Solution588
 */
@Question(
        tags = {Tag.DESIGN, Tag.HASH_TABLE, Tag.LINKED_LIST, Tag.DOUBLY_LINKED_LIST},
        difficulty = Difficulty.HARD
)
public class LFUCache {

    private final int capacity;
    private final Map<Integer, Entry> map;
    private final PriorityQueue<Integer> freqQueue;
    private final Map<Integer, Entry> freqHead;
    private final Map<Integer, Entry> freqTail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.freqQueue = new PriorityQueue<>(capacity);
        this.freqHead = new HashMap<>(capacity);
        this.freqTail = new HashMap<>(capacity);
    }

    public int get(int key) {
        Entry t = map.get(key);
        if (t == null) {
            return -1;
        }
        unlink(t);
        t.freq++;
        linkFreq(t);
        return t.value;
    }

    public void put(int key, int value) {
        Entry t = map.get(key);
        if (t != null) {
            t.value = value;
            unlink(t);
            t.freq++;
            linkFreq(t);
        } else {
            if (map.size() == capacity) { // remove least frequently used
                while (!freqQueue.isEmpty()) {
                    int freq = freqQueue.peek();
                    if (freqHead.get(freq).next != freqTail.get(freq)) {
                        break;
                    }
                    // remove empty freq
                    freqQueue.poll();
                    freqHead.remove(freq);
                    freqTail.remove(freq);
                }
                Entry head = freqHead.get(freqQueue.peek());
                map.remove(head.next.key);
                unlink(head.next);
            }
            t = new Entry(key, value);
            map.put(key, t);
            linkFreq(t);
        }
    }

    void unlink(Entry t) {
        t.prev.next = t.next;
        t.next.prev = t.prev;
        t.prev = null;
        t.next = null;
    }

    void linkFreq(Entry t) {
        int freq = t.freq;
        Entry tail = freqTail.get(freq);
        if (tail == null) { // create head and tail for new frequency
            Entry head = new Entry(0, 0);
            tail = new Entry(0, 0);
            freqQueue.offer(freq);
            freqHead.put(freq, head);
            freqTail.put(freq, tail);
            head.next = tail;
            tail.prev = head;
        }
        t.prev = tail.prev;
        t.next = tail;
        t.prev.next = t;
        t.next.prev = t;
    }

    static class Entry {

        final int key;
        int value;
        int freq;
        Entry prev;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
}