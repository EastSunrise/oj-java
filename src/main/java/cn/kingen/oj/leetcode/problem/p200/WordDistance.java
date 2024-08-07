package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/shortest-word-distance-ii/">244. Shortest Word Distance II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution21
 * @see cn.kingen.oj.leetcode.problem.p200.Solution243
 * @see cn.kingen.oj.leetcode.problem.p200.Solution245
 */
@Question(
        paidOnly = true,
        tags = {Tag.DESIGN, Tag.ARRAY, Tag.HASH_TABLE, Tag.TWO_POINTERS, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class WordDistance {

    private final Map<String, List<Integer>> map = new HashMap<>();

    @Complexity(time = "O(n)", space = "O(n)")
    public WordDistance(String[] wordsDict) {
        int n = wordsDict.length;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
        }
    }

    @Complexity(time = "O(n)", space = "O(1)")
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1), n = map.get(word2);
        int m = l1.size(), n2 = n.size();
        int ans = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < m && j < n2; ) {
            int a = l1.get(i), b = n.get(j);
            if (a < b) {
                ans = Math.min(ans, b - a);
                i++;
            } else {
                ans = Math.min(ans, a - b);
                j++;
            }
        }
        return ans;
    }
}