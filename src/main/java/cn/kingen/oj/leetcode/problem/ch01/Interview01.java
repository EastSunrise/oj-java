package cn.kingen.oj.leetcode.problem.ch01;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/is-unique-lcci/">面试题 01.01. Is Unique LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.HASH_TABLE, Tag.STRING, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Interview01 {

    @Complexity(time = "O(C)", space = "O(1)", note = "C is the number of distinct characters")
    public boolean isUnique(String astr) {
        int len = astr.length();
        if (len > 26) {
            return false;
        }
        int mask = 0;
        for (int i = 0; i < len; i++) {
            int v = 1 << (astr.charAt(i) - 'a');
            if ((mask & v) != 0) {
                return false;
            }
            mask |= v;
        }
        return true;
    }
}