package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/design-memory-allocator/">2502. Design Memory Allocator</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.DESIGN, Tag.ARRAY, Tag.HASH_TABLE, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM,
        date = "2025-02-25"
)
public class Allocator {

    private final TreeMap<Integer, Integer> availableByIndex = new TreeMap<>();
    private final Map<Integer, Map<Integer, Integer>> allocatedById = new HashMap<>();

    public Allocator(int n) {
        this.availableByIndex.put(0, n);
    }

    public int allocate(int size, int mID) {
        int start = -1;
        for (Map.Entry<Integer, Integer> entry : availableByIndex.entrySet()) {
            if (entry.getValue() >= size) {
                start = entry.getKey();
                break;
            }
        }
        if (start == -1) {
            return -1;
        }

        int leftSize = this.availableByIndex.remove(start) - size;
        if (leftSize > 0) {
            this.availableByIndex.put(start + size, leftSize);
        }
        this.allocatedById.computeIfAbsent(mID, s -> new HashMap<>()).put(start, size);
        return start;
    }

    public int freeMemory(int mID) {
        Map<Integer, Integer> blocks = this.allocatedById.remove(mID);
        if (blocks == null) {
            return 0;
        }

        int totalSize = 0;
        for (Map.Entry<Integer, Integer> entry : blocks.entrySet()) {
            totalSize += entry.getValue();

            int start = entry.getKey(), end = start + entry.getValue();
            Map.Entry<Integer, Integer> prev = this.availableByIndex.lowerEntry(start);
            if (prev != null && prev.getKey() + prev.getValue() == start) { // continuous with previous empty block
                start = prev.getKey();
            }
            Integer nextSize = this.availableByIndex.remove(end);
            if (nextSize != null) { // continuous with next empty block
                end += nextSize;
            }
            this.availableByIndex.put(start, end - start);
        }
        return totalSize;
    }

}