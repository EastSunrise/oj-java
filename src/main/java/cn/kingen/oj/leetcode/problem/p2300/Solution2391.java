package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-amount-of-time-to-collect-garbage/">2391. Minimum Amount of Time to Collect Garbage</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.STRING, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM
)
public class Solution2391 {

    @Complexity(time = "O(nm)", space = "O(1)")
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int ans = 0, gi = 0, pi = 0, mi = 0;
        for (int i = 0; i < n; i++) {
            if (garbage[i].indexOf('G') >= 0) {
                while (gi < i) {
                    ans += travel[gi++];
                }
            }
            if (garbage[i].indexOf('P') >= 0) {
                while (pi < i) {
                    ans += travel[pi++];
                }
            }
            if (garbage[i].indexOf('M') >= 0) {
                while (mi < i) {
                    ans += travel[mi++];
                }
            }
            ans += garbage[i].length();
        }
        return ans;
    }
}