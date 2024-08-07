package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/task-scheduler/">621. Task Scheduler</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution358
 * @see cn.kingen.oj.leetcode.problem.p700.Solution767
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1953
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2323
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2365
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.HASH_TABLE, Tag.COUNTING, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution621 {

    /**
     * Assumes that A, B and C are the most-occurred ones, then tasks are best to be arranged like:
     * A->B->C->X->···->A->B->C->Y->···->A->B->C where each interval between A-B-Cs
     * has to include <i>n-2 or more</i> other tasks.
     */
    @Complexity(time = "O(n+C)", space = "O(1)", note = "C is the size of task set")
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        int max = freq[0], cnt = 1;
        for (int i = 1; i < 26; i++) {
            if (freq[i] == max) {
                cnt++;
            } else if (freq[i] > max) {
                max = freq[i];
                cnt = 1;
            }
        }
        return Math.max((max - 1) * (n + 1) + cnt, tasks.length);
    }
}