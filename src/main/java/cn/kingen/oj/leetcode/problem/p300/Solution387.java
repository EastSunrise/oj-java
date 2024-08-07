package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/first-unique-character-in-a-string/">387. First Unique Character in a String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution451
 */
@Question(
        tags = {Tag.QUEUE, Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING},
        difficulty = Difficulty.EASY
)
public class Solution387 {

    @Complexity(time = "O(n+C)", space = "O(C)", note = "C is the number of distinct characters")
    public int firstUniqChar(String s) {
        int n = s.length();
        // freq[k]: count and first index of char k+'a'
        int[][] freq = new int[26][2];
        for (int i = 0; i < n; i++) {
            int k = s.charAt(i) - 'a';
            freq[k][0]++;
            freq[k][1] = i;
        }
        int first = n;
        for (int[] count : freq) {
            if (count[0] == 1 && count[1] < first) {
                first = count[1];
            }
        }
        return first == n ? -1 : first;
    }
}