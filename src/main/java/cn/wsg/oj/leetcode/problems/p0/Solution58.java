package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 58. Length of Last Word (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/length-of-last-word/">Length of Last Word</a>
 */
class Solution58 implements Solution {

    /**
     * @complexity T=O(l), l=length of the last word and the spaces after it
     * @see Complexity#SPACE_CONSTANT
     */
    public int lengthOfLastWord(String s) {
        int j = s.length() - 1;
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }
        int i = j - 1;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return j - i;
    }
}
