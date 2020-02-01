package wsg.oj.java.leetcode.problems;

import java.util.LinkedHashMap;

/**
 * @author Kingen
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (capacity > 0) {
            if (!map.containsKey(key) && map.size() == capacity)
                map.remove(map.keySet().iterator().next());
            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 6);
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
