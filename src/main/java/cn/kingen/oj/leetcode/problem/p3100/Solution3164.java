package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-the-number-of-good-pairs-ii/">3164. Find the Number of Good Pairs II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2183
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.MEDIUM
)
public class Solution3164 {

    @Complexity(time = "O(n*sqrt(C)+m)", space = "O(m)", note = "C is the average of nums1")
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num2 : nums2) {
            map.merge(num2, 1, Integer::sum);
        }
        long ans = 0;
        for (int num1 : nums1) {
            if (num1 % k != 0) {
                continue;
            }
            num1 /= k;
            for (int a = 1, sqrt = (int) Math.sqrt(num1); a <= sqrt; a++) {
                if (num1 % a == 0) {
                    ans += map.getOrDefault(a, 0);
                    if (a != num1 / a) {
                        ans += map.getOrDefault(num1 / a, 0);
                    }
                }
            }
        }
        return ans;
    }
}