package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-alloys/">2861. Maximum Number of Alloys</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM
)
public class Solution2861 {

    @Complexity(time = "O(nk*log{C})", space = "O(1)")
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int ans = 0;
        for (List<Integer> comp : composition) {
            int high = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                high = Math.min(high, (budget / cost.get(i) + stock.get(i)) / comp.get(i));
            }
            if (high <= ans) {
                continue;
            }
            int low = ans + 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (isValid(n, budget, comp, stock, cost, mid)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            ans = high;
        }
        return ans;
    }

    private boolean isValid(int n, int budget, List<Integer> comp, List<Integer> stock, List<Integer> cost, int alloys) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int exist = stock.get(i), required = comp.get(i) * alloys;
            if (exist < required) {
                sum += cost.get(i) * (required - exist);
                if (sum > budget) {
                    return false;
                }
            }
        }
        return true;
    }
}