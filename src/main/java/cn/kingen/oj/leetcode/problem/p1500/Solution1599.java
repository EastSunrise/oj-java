package cn.kingen.oj.leetcode.problem.p1500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/">1599. Maximum Profit of Operating a Centennial Wheel</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution1599 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (boardingCost * 4 <= runningCost) {
            return -1;
        }

        int waiting = 0, benefit = 0, maxBenefit = 0, cnt = 0, ans = -1;
        for (int customer : customers) {
            waiting += customer;
            int boardingCnt = Math.min(4, waiting);
            waiting -= boardingCnt;
            benefit += boardingCnt * boardingCost - runningCost;
            cnt++;
            if (benefit > maxBenefit) {
                maxBenefit = benefit;
                ans = cnt;
            }
        }

        int fourCnt = waiting / 4;
        cnt += fourCnt;
        benefit += fourCnt * (4 * boardingCost - runningCost);
        if (benefit > maxBenefit) {
            maxBenefit = benefit;
            ans = cnt;
        }

        waiting -= fourCnt * 4;
        int boardingCnt = Math.min(4, waiting);
        benefit += boardingCnt * boardingCost - runningCost;
        cnt++;
        if (benefit > maxBenefit) {
            ans = cnt;
        }
        return ans;
    }
}