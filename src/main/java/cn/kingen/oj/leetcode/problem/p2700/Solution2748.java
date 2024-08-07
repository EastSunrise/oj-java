package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/number-of-beautiful-pairs/">2748. Number of Beautiful Pairs</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.MATH, Tag.COUNTING, Tag.NUMBER_THEORY},
        difficulty = Difficulty.EASY
)
public class Solution2748 {

    int[][] coprimes = {
            {},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 3, 5, 7, 9},
            {1, 2, 4, 5, 7, 8},
            {1, 3, 5, 7, 9},
            {1, 2, 3, 4, 6, 7, 8, 9},
            {1, 5, 7},
            {1, 2, 3, 4, 5, 6, 8, 9},
            {1, 3, 5, 7, 9},
            {1, 2, 4, 5, 7, 8}
    };

    @Complexity(time = "O(n*(10+log{C})", space = "O(10)", note = "C is the maximum in the array")
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        int[] count = new int[10];
        for (int num : nums) {
            int last = num % 10;
            for (int coprime : coprimes[last]) {
                ans += count[coprime];
            }

            int first = num;
            while (first >= 10) {
                first /= 10;
            }
            count[first]++;
        }
        return ans;
    }
}