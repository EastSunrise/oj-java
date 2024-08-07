package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.*;

import static cn.kingen.oj.leetcode.util.TrieUtils.insertWord;

/**
 * <a href="https://leetcode.cn/problems/design-add-and-search-words-data-structure/">211. Design Add and Search Words Data Structure</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Trie
 * @see cn.kingen.oj.leetcode.problem.p700.WordFilter
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2301
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2416
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3045
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3042
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.DESIGN, Tag.TRIE, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class WordDictionary {

    private final TrieNode root;

    @Complexity(time = "#", space = "O(T*C)", note = "T is sum of lengths of all words, C is 26")
    public WordDictionary() {
        this.root = new TrieNode();
    }

    @Complexity(time = "O(n)", space = "O(n)")
    public void addWord(String word) {
        insertWord(root, word);
    }

    @Complexity(time = "O(C^n)", space = "O(1)")
    public boolean search(String word) {
        return search(this.root, word, 0);
    }

    private boolean search(TrieNode t, String word, int i) {
        if (i == word.length()) {
            return t.end;
        }
        char ch = word.charAt(i);
        if (ch == '.') {
            for (TrieNode child : t.next) {
                if (child != null && search(child, word, i + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = ch - 'a';
            return t.next[idx] != null && search(t.next[idx], word, i + 1);
        }
    }
}