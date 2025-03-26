package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

/**
 * <a href="https://leetcode.cn/problems/count-almost-equal-pairs-i/">3265. Count Almost Equal Pairs I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1790
 */
@Question(
        difficulty = Difficulty.MEDIUM
)
public class Solution3265 {

    @Complexity(time = "O(C*n^2)", space = "O(1)", note = "C is the average length of nums")
    public int countPairs(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(nums[i], nums[j])) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isSimilar(int x, int y) {
        if (x == y) {
            return true;
        }
        int p = -1, q = -1;
        while (x != 0 || y != 0) {
            int a = x % 10, b = y % 10;
            x /= 10;
            y /= 10;
            if (a == b) {
                continue;
            }
            if (p == -1) { // the first different pair
                p = a;
                q = b;
            } else if (p >= 0) { // the second different pair
                if (p != b || q != a) {
                    return false;
                }
                p = -2;
            } else { // more than two different pairs
                return false;
            }
        }
        return p < 0;
    }
}