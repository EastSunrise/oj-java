package wsg.oj.java.leetcode.problems.impl;

/**
 * 211. Design Add and Search Words Data Structure (Medium)
 *
 * @author Kingen
 * @see Trie
 * @see WordFilter
 * @see <a href="https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/">Design
 * Add and Search Words Data Structure</a>
 * @since 2021-06-25
 */
public class WordDictionary {

    private final Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node node = this.root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.next[i] == null) {
                node.next[i] = new Node();
            }
            node = node.next[i];
        }
        node.end = true;
    }

    public boolean search(String word) {
        return search(this.root, word.toCharArray(), 0);
    }

    private boolean search(Node node, char[] chars, int i) {
        if (i == chars.length) {
            return node.end;
        }
        char ch = chars[i++];
        if (ch == '.') {
            for (Node child : node.next) {
                if (child != null && search(child, chars, i)) {
                    return true;
                }
            }
            return false;
        }
        int idx = ch - 'a';
        return node.next[idx] != null && search(node.next[idx], chars, i);
    }

    static class Node {

        boolean end = false;
        Node[] next = new Node[26];
    }
}
