package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Stack;

/**
 * 388. Longest Absolute File Path (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/longest-absolute-file-path/">Longest Absolute File
 * Path</a>
 */
public class Solution388 implements Solution {

    /**
     * @complexity T=O(n)
     * @complexity S=O(L), L=largest level of directories
     */
    public int lengthLongestPath(String input) {
        int res = 0;
        boolean isDir = true;
        Stack<Integer> dirLens = new Stack<>();
        int nameLen = 0;
        // for the last file
        input += "\n";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '\n') {
                if (isDir) {
                    // end of a directory
                    dirLens.push(nameLen);
                } else {
                    // end of a file
                    // calculate the length of its absolute path
                    int length = nameLen;
                    for (int dirLen : dirLens) {
                        length += dirLen + 1;
                    }
                    res = Math.max(res, length);
                    isDir = true;
                }
                // rearrange the correct parent directory for next file or directory by tabs
                int tabs = 0;
                while (++i < input.length() && input.charAt(i) == '\t') {
                    tabs++;
                }
                while (dirLens.size() > tabs) {
                    dirLens.pop();
                }
                nameLen = 1;
            } else {
                if (ch == '.') {
                    isDir = false;
                }
                nameLen++;
            }
        }
        return res;
    }
}
