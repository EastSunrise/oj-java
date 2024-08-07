package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/">448. Find All Numbers Disappeared in an Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution41
 * @see cn.kingen.oj.leetcode.problem.p400.Solution442
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.EASY
)
public class Solution448 {

    @Complexity(time = "O(n)", space = "O(1)")
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int i = (num - 1) % n;
            nums[i] += n;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}