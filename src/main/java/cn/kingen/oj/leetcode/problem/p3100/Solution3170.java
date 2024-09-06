package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/lexicographically-minimum-string-after-removing-stars/">3170. Lexicographically Minimum String After Removing Stars</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STACK, Tag.GREEDY, Tag.HASH_TABLE, Tag.STRING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution3170 {

    @Complexity(time = "O(n*log(n))", space = "O(n)")
    public String clearStars(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        PriorityQueue<Integer> queue = new PriorityQueue<>((i, j) -> chars[i] == chars[j] ? j - i : chars[i] - chars[j]);
        for (int i = 0; i < n; i++) {
            if (chars[i] == '*') {
                if (!queue.isEmpty()) {
                    chars[queue.poll()] = '*'; // mark as deleted
                }
            } else {
                queue.offer(i);
            }
        }
        int size = 0;
        for (char ch : chars) {
            if (ch != '*') {
                chars[size++] = ch;
            }
        }
        return new String(chars, 0, size);
    }
}