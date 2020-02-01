package wsg.oj.java.leetcode.problems.solution;

import java.util.*;

/**
 * @author Kingen
 */
public class HashSolution {
    // 953. 验证外星语词典
    public boolean isAlienSorted(String[] words, String order) {
        int[] values = new int[26];
        char[] charArray = order.toCharArray();
        for (int i = 0; i < charArray.length; i++)
            values[charArray[i] - 'a'] = i;
        for (int i = 1; i < words.length; i++)
            if (compareAlienString(words[i - 1], words[i], values) > 0)
                return false;
        return true;
    }

    private int compareAlienString(String s1, String s2, int[] values) {
        int index = 0;
        while (index < s1.length() && index < s2.length()) {
            int comp = values[s1.charAt(index) - 'a'] - values[s2.charAt(index) - 'a'];
            if (comp != 0)
                return comp;
            index++;
        }
        return s1.length() - s2.length();
    }

    // 884. 两句话中的不常见单词
    public String[] uncommonFromSentences(String A, String B) {
        String[] as = A.split(" "), bs = B.split(" ");
        Set<String> unique = new HashSet<>(), duplicate = new HashSet<>();
        for (String a : as)
            if (!unique.add(a))
                duplicate.add(a);
        for (String b : bs)
            if (!unique.add(b))
                duplicate.add(b);
        unique.removeAll(duplicate);
        return unique.toArray(new String[0]);
    }

    // 811. 子域名访问计数
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            String domain = parts[1];
            int count = Integer.valueOf(parts[0]);

            Integer last;
            do {
                last = map.get(domain);
                if (last == null) last = 0;
                map.put(domain, last + count);
                domain = domain.substring(domain.indexOf('.') + 1);
            } while (domain.indexOf('.') >= 0);
            last = map.get(domain);
            if (last == null) last = 0;
            map.put(domain, last + count);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet())
            list.add(entry.getValue() + " " + entry.getKey());
        return list;
    }

    // 771. 宝石与石头
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (char c : S.toCharArray())
            for (char j : J.toCharArray())
                if (c == j) {
                    count++;
                    break;
                }
        return count;
    }

    // 748. 最短完整词
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] counts = new int[26];
        for (char c : licensePlate.toCharArray())
            if (c >= 'a' && c <= 'z')
                counts[c - 'a']++;
        String target = null;
        int len = 16;
        for (String word : words) {
            int[] copy = Arrays.copyOf(counts, 26);
            for (char c : word.toCharArray())
                copy[c - 'a']--;
            boolean completed = true;
            for (int i : copy)
                if (i > 0) {
                    completed = false;
                    break;
                }
            if (completed && word.length() < len) {
                target = word;
                len = word.length();
            }
        }
        return target;
    }

    // 599. 两个列表的最小索引总和
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        int len1 = list1.length, len2 = list2.length;
        for (int sum = 0, sumLen = len1 + len2 - 1; sum < sumLen; sum++) {
            int i = 0;
            while (sum - i >= len2)
                i++;
            for (; i > sum - len2 && i < len1 && i <= sum; i++)
                if (list1[i].equals(list2[sum - i]))
                    list.add(list1[i]);
            if (list.size() > 0)
                break;
        }
        return list.toArray(new String[0]);
    }

    // 500. 键盘行
    public String[] findWords(String[] words) {
        char[] row3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'},
                row2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        int[] rows = new int[26];
        for (char c : row2) rows[c - 'a'] = 1;
        for (char c : row3) rows[c - 'a'] = 2;
        List<String> list = new ArrayList<>();
        for (String word : words) {
            String lowerCase = word.toLowerCase();
            int row = rows[lowerCase.charAt(0) - 'a'];
            boolean sameRow = true;
            for (int i = 1; i < lowerCase.length(); i++)
                if (rows[lowerCase.charAt(i) - 'a'] != row) {
                    sameRow = false;
                    break;
                }
            if (sameRow)
                list.add(word);
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        new HashSolution().findAnagrams("cbaebabacd", "abc");
    }

    // 290. 单词模式
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] words = str.split(" ");
        if (chars.length != words.length)
            return false;
        for (int i = 0; i < chars.length; i++) {
            String origin = p2s.put(chars[i], words[i]);
            Character c = s2p.put(words[i], chars[i]);
            if ((origin != null && !origin.equals(words[i])) || (c != null && !c.equals(chars[i])))
                return false;
        }
        return true;
    }

    // 409. 最长回文串
    public int longestPalindrome(String s) {
        int[] counts = new int[58];
        for (char c : s.toCharArray())
            counts[c - 'A']++;
        int len = 0;
        boolean hasOdd = false;
        for (int count : counts)
            if (count % 2 == 0)
                len += count;
            else {
                hasOdd = true;
                len += count - 1;
            }
        return hasOdd ? len + 1 : len;
    }

    // 438. 找到字符串中所有字母异位词
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length())
            return list;
        int len = p.length();

        int[] pCounts = new int[26];
        for (char c : p.toCharArray())
            pCounts[c - 'a']++;
        int[] sCounts = new int[26];
        for (int i = 0; i < len; i++)
            sCounts[s.charAt(i) - 'a']++;

        int index = 0;
        while (true) {
            boolean isEqual = true;
            for (int i = 0; i < 26; i++)
                if (pCounts[i] != sCounts[i]) {
                    isEqual = false;
                    break;
                }
            if (isEqual)
                list.add(index);
            if (index + len >= s.length())
                break;
            sCounts[s.charAt(index) - 'a']--;
            sCounts[s.charAt(index + len) - 'a']++;
            index++;
        }
        return list;
    }
}
