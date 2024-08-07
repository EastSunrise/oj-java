package cn.kingen.oj.leetcode.util;

import cn.kingen.oj.leetcode.support.TrieNode;

/**
 * @author Kingen
 **/
public final class TrieUtils {

    /**
     * Inserts a word into the trie.
     */
    public static void insertWord(TrieNode root, String word) {
        TrieNode t = root;
        for (int i = 0, n = word.length(); i < n; i++) {
            int idx = word.charAt(i) - 'a';
            if (t.next[idx] == null) {
                t.next[idx] = new TrieNode();
            }
            t = t.next[idx];
        }
        t.end = true;
    }
}
