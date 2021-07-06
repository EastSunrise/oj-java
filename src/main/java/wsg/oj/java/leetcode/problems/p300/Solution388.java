package wsg.oj.java.leetcode.problems.p300;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.Solution;

/**
 * 388. Longest Absolute File Path (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/longest-absolute-file-path/">Longest Absolute File
 * Path</a>
 * @since 2021-07-06
 */
class Solution388 extends Solution {

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
