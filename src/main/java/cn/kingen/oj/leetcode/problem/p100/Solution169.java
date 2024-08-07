package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/majority-element/">169. Majority Element</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution229
 * @see cn.kingen.oj.leetcode.problem.p1100.Solution1150
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2404
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2780
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3065
 */
@Question(tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.DIVIDE_AND_CONQUER, Tag.COUNTING, Tag.SORTING}, difficulty = Difficulty.EASY)
public class Solution169 {

    /**
     * Boyer-Moore voting algorithm: delete/nullify two different numbers from the array
     * every time, then the only left number is the majority one.
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int major = nums[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (major == nums[i]) {
                count++;
            } else if (count == 0) {
                count++;
                major = nums[i];
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (major == num) {
                count++;
            }
        }
        return count > n / 2 ? major : -1;
    }
}