package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/minimum-rounds-to-complete-all-tasks/">2244. Minimum Rounds to Complete All Tasks</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution70
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2451
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3096
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.HASH_TABLE, Tag.COUNTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2244 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> stat = new HashMap<>();
        for (int task : tasks) {
            stat.merge(task, 1, Integer::sum);
        }
        int ans = 0;
        for (int count : stat.values()) {
            if (count == 1) {
                return -1;
            }
            ans += count / 3 + (count % 3 == 0 ? 0 : 1);
        }
        return ans;
    }
}