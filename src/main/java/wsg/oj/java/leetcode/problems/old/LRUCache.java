package wsg.oj.java.leetcode.problems.old;

import java.util.LinkedHashMap;

/**
 * @author Kingen
 */
public class LRUCache {

    private final LinkedHashMap<Integer, Integer> map;
    private final int capacity;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (capacity > 0) {
            if (!map.containsKey(key) && map.size() == capacity) {
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
        }
    }
}
