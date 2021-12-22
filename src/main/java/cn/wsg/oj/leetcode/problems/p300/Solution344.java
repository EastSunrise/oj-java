package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p500.Solution541;

/**
 * 344. Reverse String (Easy)
 *
 * @author Kingen
 * @see Solution345
 * @see Solution541
 * @see <a href="https://leetcode-cn.com/problems/reverse-string/">Reverse String</a>
 */
public class Solution344 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
