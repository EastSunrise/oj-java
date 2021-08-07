package wsg.oj.java.algorithm;

/**
 * @author Kingen
 * @since 2021/7/10
 */
public interface PatternSearching {

    /**
     * Searches the pattern within the text.
     *
     * @param txt the text where to search the pattern
     * @param pat the pattern to be searched
     * @return the index of the first occurrence of the pattern, or {@code -1} if there is no such
     * occurrence.
     */
    int search(char[] txt, char[] pat);
}
