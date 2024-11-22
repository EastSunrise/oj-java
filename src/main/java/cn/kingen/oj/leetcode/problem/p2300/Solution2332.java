package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/the-latest-time-to-catch-a-bus/">2332. The Latest Time to Catch a Bus</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1870
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2410
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2534
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2532
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2561
 */
@Question(
    tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.BINARY_SEARCH, Tag.SORTING},
    difficulty = Difficulty.MEDIUM
)
public class Solution2332 {

    @Complexity(time = "O(n*log(n)+m*log(m))", space = "O(1)")
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int n = buses.length, m = passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int p = 0, cnt = 0;
        for (int bus : buses) {
            cnt = 0;
            while (cnt < capacity && p < m && passengers[p] <= bus) {
                p++;
                cnt++;
            } // passengers[p-cnt, p-1] get on the bus
        }

        int last = cnt < capacity ? buses[n - 1] : passengers[p - 1];
        while (--p >= 0 && passengers[p] == last) { // find the last empty time
            last--;
        }
        return last;
    }
}