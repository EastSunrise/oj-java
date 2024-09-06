package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/happy-students/">2860. Happy Students</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.ENUMERATION, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2860 {

    @Complexity(time = "O(n*log(n))", space = "O(1)")
    public int countWays(List<Integer> nums) {
        int n = nums.size();
        Collections.sort(nums);
        int ans = 0;
        if (nums.getFirst() > 0) {
            ans++;
        }
        for (int c = 1; c < n; c++) { // c is the count of chosen numbers
            if (nums.get(c - 1) < c && c < nums.get(c)) {
                ans++;
            }
        }
        return ans + 1;
    }
}