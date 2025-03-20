package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/minimum-reverse-operations/">2612. Minimum Reverse Operations</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.BREADTH_FIRST_SEARCH, Tag.ARRAY, Tag.ORDERED_SET},
        difficulty = Difficulty.HARD,
        date = "2025-03-20"
)
public class Solution2612 {

    @Complexity(time = "O(n*log(n))", space = "O(n)")
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] ans = new int[n];
        for (int ban : banned) {
            ans[ban] = -1;
        }

        TreeSet<Integer> odd = new TreeSet<>(), even = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (i == p || ans[i] == -1) {
                continue;
            }
            if ((i & 1) == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(p);
        while (!queue.isEmpty()) {
            int x = queue.remove();
            int ymn = Math.max(x - k + 1, k - x - 1);
            int ymx = Math.min(2 * n - k - x - 1, x + k - 1);
            TreeSet<Integer> set = (ymn & 1) == 0 ? even : odd;
            Iterator<Integer> iterator = set.subSet(ymn, true, ymx, true).iterator();
            for (; iterator.hasNext(); iterator.remove()) {
                int y = iterator.next();
                ans[y] = ans[x] + 1;
                queue.offer(y);
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == 0) {
                ans[i] = -1;
            }
        }
        ans[p] = 0;
        return ans;
    }
}