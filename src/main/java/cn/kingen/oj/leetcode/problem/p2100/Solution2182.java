package cn.kingen.oj.leetcode.problem.p2100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/construct-string-with-repeat-limit/">2182. Construct String With Repeat Limit</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution358
 */
@Question(
        tags = {Tag.GREEDY, Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution2182 {

    @Complexity(time = "O(n+C)", space = "O(C)", note = "C is the number of distinct characters")
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] map = new int[26];
        for (int i = s.length() - 1; i >= 0; i--) {
            map[s.charAt(i) - 'a']++;
        }

        int i = map.length - 1, j = map.length - 2;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            if (map[i] == 0) {
                i = j;
                j--;
            } else if (map[i] <= repeatLimit) {
                sb.append(String.valueOf((char) ('a' + i)).repeat(map[i]));
                map[i] = 0;
                i = j;
                j--;
            } else {
                sb.append(String.valueOf((char) ('a' + i)).repeat(repeatLimit));
                map[i] -= repeatLimit;
                for (; j >= 0; j--) {
                    if (map[j] > 0) {
                        sb.append((char) ('a' + j));
                        map[j]--;
                        break;
                    }
                }
                if (j < 0) {
                    break;
                }
            }
        }
        return sb.toString();
    }
}