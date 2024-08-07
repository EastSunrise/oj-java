package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/delete-and-earn/">740. Delete and Earn</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution198
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution740 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> sums = new ArrayList<>();
        int size = 0, num = nums[0], count = 1;
        for (int j = 1; j < n; j++) {
            if (nums[j] == num) {
                count++;
            } else {
                nums[size++] = num;
                sums.add(num * count);
                num = nums[j];
                count = 1;
            }
        }
        nums[size++] = num;
        sums.add(num * count);

        int prev = 0, cur = sums.getFirst(), next;
        for (int i = 1; i < size; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                next = Math.max(prev + sums.get(i), cur);
            } else {
                next = cur + sums.get(i);
            }
            prev = cur;
            cur = next;
        }
        return cur;
    }
}