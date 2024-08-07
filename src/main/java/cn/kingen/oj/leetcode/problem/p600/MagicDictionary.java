package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.*;

import static cn.kingen.oj.leetcode.util.TrieUtils.insertWord;

/**
 * <a href="https://leetcode.cn/problems/implement-magic-dictionary/">676. Implement Magic Dictionary</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Trie
 * @see cn.kingen.oj.leetcode.problem.p700.Solution720
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.DESIGN, Tag.TRIE, Tag.HASH_TABLE, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class MagicDictionary {

    private final TrieNode root;

    @Complexity(time = "#", space = "O(T*C)", note = "T is sum of lengths of all words, C is 26")
    public MagicDictionary() {
        this.root = new TrieNode();
    }

    @Complexity(time = "O(T*C)", space = "O(T*C)")
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            insertWord(root, word);
        }
    }

    @Complexity(time = "O(n*C)", space = "O(1)", note = "n is the length of searchWord")
    public boolean search(String searchWord) {
        TrieNode t = root;
        for (int i = 0, n = searchWord.length(); i < n; i++) {
            int idx = searchWord.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if (j != idx && t.next[j] != null) {
                    if (search(t.next[j], searchWord, i + 1)) {
                        return true;
                    }
                }
            }
            if (t.next[idx] == null) {
                return false;
            }
            t = t.next[idx];
        }
        return false;
    }

    private boolean search(TrieNode t, String word, int i) {
        for (int n = word.length(); i < n; i++) {
            int idx = word.charAt(i) - 'a';
            if (t.next[idx] == null) {
                return false;
            }
            t = t.next[idx];
        }
        return t.end;
    }
}