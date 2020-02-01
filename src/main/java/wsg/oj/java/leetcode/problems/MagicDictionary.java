package wsg.oj.java.leetcode.problems;

/**
 * @author Kingen
 */
public class MagicDictionary {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        MagicDictionary dictionary = new MagicDictionary();
        dictionary.buildDict(new String[]{
                "hello", "leetcode"
        });
        dictionary.search("hello");
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            insert(s);
        }
    }

    private void insert(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        TrieNode node = root;
        char[] letters = str.toCharArray();
        for (char letter : letters) {
            int pos = letter - 'a';
            if (node.son[pos] == null) { //如果当前节点的儿子节点中没有该字符，则构建一个TrieNode并复值该字符
                node.son[pos] = new TrieNode();
                node.son[pos].val = letter;
            } else node.son[pos].num++;
            node = node.son[pos];
        }
        node.isEnd = true;
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        TrieNode node = root;
        char[] letters = str.toCharArray();
        for (int i = 0, len = str.length(); i < len; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] != null) {
                node = node.son[pos];
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    private class TrieNode {
        public static final int SIZE = 26;
        private int num;// 有多少单词通过这个节点,即由根至该节点组成的字符串模式出现的次数
        private TrieNode[] son;// 所有的儿子节点
        private boolean isEnd;// 是不是最后一个节点
        private char val;// 节点的值

        TrieNode() {
            num = 1;
            son = new TrieNode[SIZE];
            isEnd = false;
        }
    }
}
