package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/top-k-frequent-words/">692. Top K Frequent Words</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution347
 * @see cn.kingen.oj.leetcode.problem.p900.Solution973

 */
@Question(
        tags = {Tag.TRIE, Tag.HASH_TABLE, Tag.STRING, Tag.BUCKET_SORT, Tag.COUNTING, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution692 {

    @Complexity(time = "O(n*log{k})", space = "O(n)")
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
        List<String> ans = new ArrayList<>(k);
        while (!queue.isEmpty()) {
            ans.add(queue.remove());
        }
        Collections.reverse(ans);
        return ans;
    }
}