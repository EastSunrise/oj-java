package cn.kingen.oj.leetcode.problem.p100;


import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/lru-cache/">146. LRU Cache</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.LFUCache
 * @see cn.kingen.oj.leetcode.problem.p500.Solution588
 * @see cn.kingen.oj.leetcode.problem.p600.Solution604
 * @see cn.kingen.oj.leetcode.problem.p10000.DCLoadBalancer
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1756
 */
@Question(
        tags = {Tag.DESIGN, Tag.HASH_TABLE, Tag.LINKED_LIST, Tag.DOUBLY_LINKED_LIST},
        difficulty = Difficulty.MEDIUM
)
public class LRUCache {

    private final int capacity;
    private final Map<Integer, Entry> map;
    private final Entry head;
    private final Entry tail;

    @Complexity(time = "O(1)", space = "O(1)")
    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Entry(0, 0);
        this.tail = new Entry(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    int get(int key) {
        Entry t = map.get(key);
        if (t == null) {
            return -1;
        }
        unlink(t);
        linkLast(t);
        return t.value;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    void put(int key, int value) {
        Entry t = map.get(key);
        if (t != null) {
            t.value = value;
            unlink(t);
            linkLast(t);
        } else {
            t = new Entry(key, value);
            if (map.size() == capacity) {
                map.remove(head.next.key);
                unlink(head.next);
            }
            map.put(key, t);
            linkLast(t);
        }
    }

    private void unlink(Entry t) {
        t.prev.next = t.next;
        t.next.prev = t.prev;
        t.prev = null;
        t.next = null;
    }

    private void linkLast(Entry t) {
        t.prev = tail.prev;
        t.next = tail;
        t.prev.next = t;
        t.next.prev = t;
    }

    static class Entry {

        final int key;
        int value;
        Entry prev;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}