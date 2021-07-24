package wsg.oj.java.datastructure;


import java.util.List;
import java.util.function.Function;

/**
 * Operations of tries.
 *
 * @author Kingen
 * @since 2021/7/24
 */
public class TrieOpt {

    /**
     * Creates a trie based on the specified dictionary.
     *
     * @param size the size of the character set
     * @return the root node of the trie
     */
    public static TrieNode create(List<String> dict,
        Function<Character, Integer> keyExtractor, int size) {
        TrieNode root = new TrieNode(size);
        for (String word : dict) {
            insert(root, word, keyExtractor, size);
        }
        return root;
    }

    /**
     * Inserts the specified word into a trie if it is not already present.
     *
     * @param size the size of the character set
     * @return {@code true} if the trie did not already contain the word
     */
    public static boolean insert(TrieNode root, String word,
        Function<Character, Integer> keyExtractor, int size) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = keyExtractor.apply(ch);
            if (node.next[i] == null) {
                node.next[i] = new TrieNode(size);
            }
            node = node.next[i];
        }
        if (node.end) {
            return true;
        }
        node.end = true;
        return false;
    }

    /**
     * Returns {@code true} if the trie contains the specified word.
     */
    public static boolean search(TrieNode root, String word,
        Function<Character, Integer> keyExtractor) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = keyExtractor.apply(ch);
            if (node.next[i] == null) {
                return false;
            }
            node = node.next[i];
        }
        return node.end;
    }

    /**
     * Returns {@code true} if this trie contains a word that starts with the specified prefix.
     */
    public static boolean startsWith(TrieNode root, String prefix,
        Function<Character, Integer> keyExtractor) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int i = keyExtractor.apply(ch);
            if (node.next[i] == null) {
                return false;
            }
            node = node.next[i];
        }
        return true;
    }
}
