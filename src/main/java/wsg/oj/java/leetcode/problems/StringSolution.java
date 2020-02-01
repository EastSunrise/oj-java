package wsg.oj.java.leetcode.problems;

import java.util.*;

/**
 * @author Kingen
 */
public class StringSolution {

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String str = "1";
        for (int i = 1; i < n; i++) {
            char[] charArray = str.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            char cur = charArray[0];
            int count = 1;
            for (int i1 = 1; i1 < charArray.length; i1++) {
                char c = charArray[i1];
                if (c != cur) {
                    stringBuilder.append(count).append(cur);
                    cur = c;
                    count = 1;
                } else
                    count++;
            }
            stringBuilder.append(count).append(cur);
            str = stringBuilder.toString();
        }
        return str;
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.equals(""))
            return 0;
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != ' ')
                len++;
            else
                return len;
        return len;
    }

    // 实现strStr()
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // 344. 反转字符串
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = -1, right = chars.length;
        while (++left < --right) {
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
        }
        return new String(chars);
    }

    // 345. 反转字符串中的元音字母
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        char[] vowels = new char[]{
                'A', 'E', 'I', 'O', 'U'
        };
        for (char vowel : vowels) {
            set.add(vowel);
            set.add((char) (vowel + 32));
        }

        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right)
            if (!set.contains(chars[left]))
                left++;
            else if (!set.contains(chars[right]))
                right--;
            else {
                char c = chars[left];
                chars[left++] = chars[right];
                chars[right--] = c;
            }
        return new String(chars);
    }

    // 383. 赎金信
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        int[] counts = new int[26];
        for (char aChar : chars)
            counts[aChar - 'a']++;
        char[] chars1 = ransomNote.toCharArray();
        for (char c : chars1)
            if (counts[c - 'a'] == 0)
                return false;
            else
                counts[c - 'a']--;
        return true;
    }

    // 387. 字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[][] counts = new int[26][2]; // [i][0]: count of char i+'a', [i][1]: first index of char i+'a'
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i] - 'a';
            int count = counts[c][0];
            if (count < 2) {
                counts[c][0]++;
                if (count < 1) counts[c][1] = i;
            }
        }
        int first = chars.length;
        for (int[] count : counts)
            if (count[0] == 1 && count[1] < first)
                first = count[1];
        return first == chars.length ? -1 : first;
    }

    // 859. 亲密字符串
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.equals(B)) {
            int[] counts = new int[26];
            for (int i = 0; i < A.length(); i++)
                counts[A.charAt(i) - 'a']++;
            for (int count : counts)
                if (count > 1)
                    return true;
            return false;
        }
        int difIndex = 0;
        char difA = 0, difB = 0;
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i), b = B.charAt(i);
            if (a != b) {
                if (difIndex == 0) {
                    difA = a;
                    difB = b;
                } else if (difIndex == 1) {
                    if (a != difB || b != difA)
                        return false;
                } else
                    return false;
                difIndex++;
            }
        }
        return difIndex != 1;
    }

    // 824. 山羊拉丁文
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        Set<Character> vowels = getVowels();
        char[] as = new char[words.length];
        Arrays.fill(as, 'a');
        for (int i = 0; i < words.length; i++) {
            StringBuilder src = new StringBuilder(words[i]);
            char first = src.charAt(0);
            if (!vowels.contains(first)) {
                src.append(first);
                src.deleteCharAt(0);
            }
            src.append("ma");
            src.append(as, 0, i + 1);
            words[i] = src.toString();
        }

        int iMax = words.length - 1;
        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(words[i]);
            if (i == iMax)
                return b.toString();
            b.append(" ");
        }
    }

    private Set<Character> getVowels() {
        Set<Character> set = new HashSet<>();
        char[] vowels = new char[]{
                'A', 'E', 'I', 'O', 'U'
        };
        for (char vowel : vowels) {
            set.add(vowel);
            set.add((char) (vowel + 32));
        }
        return set;
    }

    // 819. 最常见的单词
    private String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bans = new HashSet<>(Arrays.asList(banned));
        bans.add("");
        paragraph = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();
        Map<String, Integer> str2CountMap = new HashMap<>();
        int maxCount = 0;
        String word = null;
        String[] words = paragraph.split(" ");
        for (String s : words)
            if (!bans.contains(s)) {
                Integer count = str2CountMap.get(s);
                count = count == null ? 1 : count + 1;
                if (count > maxCount) {
                    maxCount = count;
                    word = s;
                }
                str2CountMap.put(s, count);
            }
        return word;
    }

    // 804. 唯一摩尔斯密码词
    public int uniqueMorseRepresentations(String[] words) {
        String[] passwords = new String[]{
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (char c : word.toCharArray())
                builder.append(passwords[c - 'a']);
            set.add(builder.toString());
        }
        return set.size();
    }

    // 929. 独特的电子邮件地址
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] localParts = parts[0].split("\\+");
            String local = localParts[0].replaceAll("\\.", "");
            set.add(local + parts[1]);
        }
        return set.size();
    }

    // 925. 长按键入
    public boolean isLongPressedName(String name, String typed) {
        char[] names = name.toCharArray(), types = typed.toCharArray();
        int nIndex = 0, tIndex = 0;
        while (nIndex < names.length && tIndex < types.length)
            if (names[nIndex] == types[tIndex]) {
                nIndex++;
                tIndex++;
            } else if (nIndex > 0 && names[nIndex - 1] == types[tIndex])
                tIndex++;
            else
                return false;
        if (nIndex < names.length)
            return false;
        while (tIndex < types.length)
            if (types[tIndex] != types[tIndex++ - 1])
                return false;
        return true;
    }

    // 893. 特殊等价字符串组
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            int[] count = new int[52];
            for (int i = 0; i < s.length(); i++)
                count[s.charAt(i) - 'a' + 26 * (i % 2)]++;
            set.add(Arrays.toString(count));
        }
        return set.size();
    }

    // 937. 重新排列日志文件
    public String[] reorderLogFiles(String[] logs) {
        List<String> strLogs = new ArrayList<>(), numLogs = new ArrayList<>();
        for (String log : logs) {
            char c = log.split(" ")[1].charAt(0);
            if (c >= 'a' && c <= 'z')
                strLogs.add(log);
            else
                numLogs.add(log);
        }
        Collections.sort(strLogs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.substring(o1.indexOf(' ')).compareTo(o2.substring(o2.indexOf(' ')));
            }
        });
        strLogs.addAll(numLogs);
        return strLogs.toArray(new String[0]);
    }

    // 443. 压缩字符串
    public int compress(char[] chars) {
        int charIndex = 0, count = 1;
        for (int i = 1; i < chars.length; i++)
            if (chars[i] == chars[i - 1]) count++;
            else {
                if (count > 1)
                    for (char c : String.valueOf(count).toCharArray())
                        chars[++charIndex] = c;
                count = 1;
                chars[++charIndex] = chars[i];
            }
        if (count > 1)
            for (char c : String.valueOf(count).toCharArray())
                chars[++charIndex] = c;
        return charIndex + 1;
    }

    // 482. 密钥格式化
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "").toUpperCase();
        if (K >= S.length())
            return S;
        int mod = S.length() % K;
        if (mod == 0)
            mod = K;
        StringBuilder builder = new StringBuilder();
        builder.append(S, 0, mod);
        while (mod < S.length()) {
            builder.append("-").append(S, mod, mod + K);
            mod += K;
        }
        return builder.toString();
    }

    // 551. 学生出勤记录 I
    public boolean checkRecord(String s) {
        int countA = 0, l = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == 'L') {
                if (l++ > 1)
                    return false;
            } else {
                l = 0;
                if (c == 'A')
                    countA++;
            }
        }
        return countA <= 1;
    }

    // 643. 子数组最大平均数 I
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > max) max = sum;
        }
        return max * 1.0 / k;
    }

    private char[][] codes = new char[][]{{
            'a', 'b', 'c'
    }, {
            'd', 'e', 'f'
    }, {
            'g', 'h', 'i'
    }, {
            'j', 'k', 'l'
    }, {
            'm', 'n', 'o'
    }, {
            'p', 'q', 'r', 's'
    }, {
            't', 'u', 'v'
    }, {
            'w', 'x', 'y', 'z'
    }};

    // 821. 字符的最短距离
    public int[] shortestToChar(String S, char C) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < S.length(); i++)
            if (C == S.charAt(i))
                indexes.add(i);
        int[] res = new int[S.length()];
        Iterator<Integer> iterator = indexes.iterator();
        int last = iterator.next();
        for (int i = 0; i < last; i++) res[i] = last - i;
        while (iterator.hasNext()) {
            int current = iterator.next();
            int mid = ((last + current) >> 1) + 1;
            for (int i = last; i < mid; i++) res[i] = i - last;
            for (int i = mid; i < current; i++) res[i] = current - i;
            last = current;
        }
        for (int i = last; i < res.length; i++) res[i] = i - last;
        return res;
    }

    // 806. 写字符串需要的行数
    public int[] numberOfLines(int[] widths, String S) {
        int line = 1, total = 0;
        for (char c : S.toCharArray()) {
            int wid = widths[c - 'a'];
            total += wid;
            if (total > 100) {
                total = wid;
                line++;
            }
        }
        return new int[]{line, total};
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> char2IndexMap = new HashMap<>();
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Integer last = char2IndexMap.get(c);
            if (last == null)
                char2IndexMap.put(c, i);
            else {
                int length = char2IndexMap.size();
                if (length > max)
                    max = length;
                char2IndexMap = new HashMap<>();
                for (int j = last + 1; j <= i; j++) char2IndexMap.put(chars[j], j);
            }
        }
        int length = char2IndexMap.size();
        if (length > max)
            max = length;
        return max;
    }

    // 5. 最长回文子串
    public String longestPalindrome(String s) {
        // wsg 马拉车算法
        return "";
    }

    private String lastAllSame(char[] chars, int len) {
        String last = String.valueOf(chars[len - 1]);
        if (len == 1 || chars[len - 1] != chars[len - 2])
            return last;
        return lastAllSame(chars, len - 1) + last;
    }

    // 6. Z 字形变换
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int len = s.length();
        int n = numRows * 2 - 2;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i += n)
            builder.append(s.charAt(i));
        for (int j = 1; j < numRows - 1; j++) {
            int k = 1;
            for (int i = j; i < len; i += n, k++) {
                builder.append(s.charAt(i));
                int next = k * n - j;
                if (next < len)
                    builder.append(s.charAt(next));
            }
        }
        for (int i = numRows - 1; i < len; i += n)
            builder.append(s.charAt(i));
        return builder.toString();
    }

    // 8. 字符串转换整数 (atoi)
    public int myAtoi(String str) {
        if (str == null)
            return 0;
        str = str.trim();
        if ("".equals(str))
            return 0;
        char first = str.charAt(0);
        if (first == '+' || first == '-' || (first >= '0' && first <= '9')) {
            int len = 0;
            while (++len < str.length()) {
                char c = str.charAt(len);
                if (c < '0' || c > '9')
                    break;
            }
            str = str.substring(0, len);
            if (str.equals("+") || str.equals("-"))
                return 0;
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return first == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return 0;
    }

    // 17. 电话号码的字母组合
    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        return letterCombinations(chars, chars.length);
    }

    private List<String> letterCombinations(char[] chars, int length) {
        List<String> list = new LinkedList<>();
        if (length == 0) {
            list.add("");
            return list;
        }
        List<String> pres = letterCombinations(chars, length - 1);
        char[] lasts = codes[chars[length - 1] - '2'];
        for (String pre : pres) for (char last : lasts) list.add(pre + last);
        return list;
    }

    // 65. 有效数字
    public boolean isNumber(String s) {
        s = s.replaceAll(" ", "");
        for (char c : s.toCharArray())
            if (c != 'e' && c != '.' && (c < '0' || c > '9'))
                return false;
        String[] parts = s.split("e", 3);
        if (parts.length > 2 || parts.length == 0)
            return false;
        for (String part : parts)
            if ("".equals(part) || part.startsWith(".") || part.endsWith(".") || part.matches(".*\\..*\\..*"))
                return false;
        return true;
    }

    // 816. 模糊坐标
    public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length() - 1);
        List<String> list = new LinkedList<>();
        for (int comma = 1; comma < S.length(); comma++)
            for (String s1 : getValidString(S.substring(0, comma)))
                for (String s2 : getValidString(S.substring(comma)))
                    list.add("(" + s1 + ", " + s2 + ")");
        return list;
    }

    private List<String> getValidString(String s) {
        List<String> list = new LinkedList<>();
        if (s.endsWith("0")) {
            if ("0".equals(s) || !s.startsWith("0"))
                list.add(s);
        } else if (s.startsWith("0"))
            list.add("0." + s.substring(1));
        else {
            list.add(s);
            for (int i = 1; i < s.length(); i++)
                list.add(s.substring(0, i) + "." + s.substring(i));
        }
        return list;
    }

    // 10. 正则表达式匹配
    public boolean isMatch(String s, String p) {
        if ("".equals(p))
            return "".equals(s);
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        return isMatch(ss, ps, ss.length, ps.length);
    }

    private boolean isMatch(char[] ss, char[] ps, int sl, int pl) {
        if (pl == 0)
            return sl == 0;
        char pLast = ps[pl - 1];
        if (pl == 1)
            return pLast != '*' && (pl == sl && (pLast == '.' || (ss[sl - 1] == pLast)));
        switch (pLast) {
            case '.':
                return sl > 0 && isMatch(ss, ps, sl - 1, pl - 1);
            case '*':
                pLast = ps[pl - 2];
                switch (pLast) {
                    case '*':
                        return isMatch(ss, ps, sl, sl - 1);
                    case '.':
                        for (int i = 0; i < sl; i++) {
                            if (isMatch(ss, ps, sl - i, pl - 2))
                                return true;
                        }
                        return isMatch(ss, ps, 0, pl - 2);
                    default:
                        for (int i = 0; i < sl; i++) {
                            if (isMatch(ss, ps, sl - i, pl - 2))
                                return true;
                            if (ss[sl - i - 1] != pLast)
                                return false;
                        }
                        return isMatch(ss, ps, 0, pl - 2);
                }
            default:
                return sl > 0 && ss[sl - 1] == pLast && isMatch(ss, ps, sl - 1, pl - 1);
        }
    }

    public static void main(String[] args) {
        new StringSolution().compareVersion("0.1", "1.1");
    }

    // 399. 除法求值
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, GroupValue> map = new HashMap<>();
        List<Set<String>> list = new LinkedList<>();
        int groupId = 0;
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            double value = values[i];
            String a = equation[0], b = equation[1];
            GroupValue groupValueA = map.get(a);
            GroupValue groupValueB = map.get(b);
            if (groupValueA != null) {
                if (groupValueB != null) {
                    int idA = groupValueA.groupId, idB = groupValueB.groupId;
                    if (idA != idB) {
                        Set<String> setA = list.get(groupValueA.groupId);
                        double k = value * groupValueB.value / groupValueA.value;
                        for (String s : setA) {
                            GroupValue groupValueS = map.get(s);
                            groupValueS.groupId = idB;
                            groupValueS.value *= k;
                        }
                        list.get(idB).addAll(setA);
                        list.set(idA, null);
                    }
                } else {
                    map.put(b, new GroupValue(groupValueA.groupId, groupValueA.value / value));
                }
            } else {
                if (groupValueB != null) {
                    map.put(a, new GroupValue(groupValueB.groupId, groupValueB.value * value));
                } else {
                    map.put(b, new GroupValue(groupId, 1));
                    map.put(a, new GroupValue(groupId++, value));
                    Set<String> set = new HashSet<>(Arrays.asList(a, b));
                    list.add(set);
                }
            }
        }
        double[] ret = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            GroupValue groupValueX = map.get(query[0]), groupValueY = map.get(query[1]);
            if (groupValueX == null || groupValueY == null || groupValueX.groupId != groupValueY.groupId)
                ret[i] = -1.0;
            else
                ret[i] = groupValueX.value / groupValueY.value;
        }
        return ret;
    }

    // 537. 复数乘法
    public String complexNumberMultiply(String a, String b) {
        int[] aInts = getInts(a), bInts = getInts(b);
        return "" + (aInts[0] * bInts[0] - aInts[1] * bInts[1])
                + "+" + (aInts[0] * bInts[1] + aInts[1] * bInts[0]) + "i";
    }

    private int[] getInts(String s) {
        String[] ss = s.substring(0, s.length() - 1).split("\\+");
        return new int[]{
                Integer.valueOf(ss[0]), Integer.valueOf(ss[1])
        };
    }

    // 187. 重复的DNA序列
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len < 10)
            return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= len - 10; i++) {
            String str = s.substring(i, i + 10);
            Integer count = map.get(str);
            if (count == null)
                count = 0;
            map.put(str, count + 1);
        }
        List<String> list = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() > 1)
                list.add(entry.getKey());
        return list;
    }

    // 388. 文件的最长绝对路径
    public int lengthLongestPath(String input) {
        char[] chars = (input + "\n").toCharArray();
        int level = 0, len = 0, length = 0, max = 0;
        boolean isFile = false;
        Stack<Integer> stack = new Stack<>();
        for (char c : chars)
            if (c == '\n') {
                if (!isFile) len++;
                while (stack.size() > level) length -= stack.pop();
                stack.push(len);
                length += len;
                if (isFile) max = Math.max(length, max);
                level = len = 0;
                isFile = false;
            } else if (c == '\t') level++;
            else {
                if (c == '.') isFile = true;
                len++;
            }
        return max;
    }

    // 165. 比较版本号
    public int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\."), vs2 = version2.split("\\.");
        int len = Math.max(vs1.length, vs2.length);
        int[] v1 = new int[len], v2 = new int[len];
        for (int i = 0; i < vs1.length; i++) v1[i] = Integer.valueOf(vs1[i]);
        for (int i = 0; i < vs2.length; i++) v2[i] = Integer.valueOf(vs2[i]);
        for (int i = 0; i < len; i++)
            if (v1[i] > v2[i]) return 1;
            else if (v1[i] < v2[i]) return -1;
        return 0;
    }

    class GroupValue {
        int groupId;
        double value;

        GroupValue(int groupId, double value) {
            this.groupId = groupId;
            this.value = value;
        }
    }
}