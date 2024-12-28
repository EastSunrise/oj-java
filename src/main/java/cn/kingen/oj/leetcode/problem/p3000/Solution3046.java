package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/split-the-array/">3046. Split the Array</a>
 *
 * @author Kingen

 */
@Question(
    tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.COUNTING},
    difficulty = Difficulty.EASY
)
public class Solution3046 {

    @Complexity(time = "O(n)", space = "O(n)")
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            int cnt = freq.getOrDefault(num, 0);
            if (cnt == 2) {
                return false;
            }
            freq.put(num, cnt + 1);
        }
        return true;
    }
}