package cn.kingen.oj.leetcode.problem.p2000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-original-array-from-doubled-array/">2007. Find Original Array From Doubled Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution954
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2122
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.HASH_TABLE, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2007 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) {
            return new int[0];
        }

        Arrays.sort(changed);
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : changed) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[n >> 1];
        int size = 0;
        for (int num : changed) {
            int cnt = count.getOrDefault(num, 0);
            if (cnt > 0) { // find minimum of remaining numbers
                ans[size++] = num;
                if (cnt == 1) {
                    count.remove(num);
                } else {
                    count.put(num, cnt - 1);
                }

                // find its double
                int db = num << 1;
                int dbCnt = count.getOrDefault(db, 0);
                if (dbCnt == 0) {
                    return new int[0];
                } else if (dbCnt == 1) {
                    count.remove(db);
                } else {
                    count.put(db, dbCnt - 1);
                }
            }
        }
        return ans;
    }
}