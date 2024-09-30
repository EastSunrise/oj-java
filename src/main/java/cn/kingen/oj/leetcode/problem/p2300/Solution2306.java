package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/naming-a-company/">2306. Naming a Company</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.ENUMERATION},
        difficulty = Difficulty.HARD
)
public class Solution2306 {

    @Complexity(time = "O(nmC)", space = "O(nm)", note = "n is the length of the array, m is the average length of strings and C is 26")
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> first2Suffix = new HashMap<>();
        for (String idea : ideas) {
            first2Suffix.computeIfAbsent(idea.charAt(0), k -> new HashSet<>()).add(idea.substring(1));
        }

        long ans = 0;
        for (Map.Entry<Character, Set<String>> entry : first2Suffix.entrySet()) {
            char xf = entry.getKey();
            Set<String> xs = entry.getValue();
            for (Character yf : first2Suffix.keySet()) {
                if (xf == yf) {
                    continue;
                }
                Set<String> ys = first2Suffix.get(yf);
                int intersectionSize = 0;
                for (String x : xs) {
                    if (ys.contains(x)) {
                        intersectionSize++;
                    }
                }
                ans += (long) (xs.size() - intersectionSize) * (ys.size() - intersectionSize);
            }
        }
        return ans;
    }
}