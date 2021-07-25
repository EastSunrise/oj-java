package wsg.oj.java.leetcode.problems.p600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution347;

/**
 * 692. Top K Frequent Words (MEDIUM)
 *
 * @author Kingen
 * @see Solution347
 * @see Solution973
 * @see Solution1772
 * @see <a href="https://leetcode-cn.com/problems/top-k-frequent-words/">Top K Frequent Words</a>
 * @since 2021-07-23
 */
class Solution692 implements Solution {

    /**
     * @complexity T=O(n+n*log_{k})
     * @complexity S=O(n+k)
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        Queue<String> queue = new PriorityQueue<>(k, (o1, o2) -> {
            int count = counts.get(o1) - counts.get(o2);
            return count != 0 ? count : o2.compareTo(o1);
        });
        for (String word : counts.keySet()) {
            queue.offer(word);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        List<String> res = new ArrayList<>(k);
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        Collections.reverse(res);
        return res;
    }
}