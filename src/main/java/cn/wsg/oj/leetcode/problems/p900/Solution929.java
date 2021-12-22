package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/unique-email-addresses/">Unique Email
 * Addresses</a>
 */
public class Solution929 implements Solution {

    /**
     * @complexity T=O(nl), n=the number of emails, l=the length of each email
     * @complexity S=O(nl)
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        for (String email : emails) {
            int at = email.indexOf('@');
            int plus = email.indexOf('+');
            if (plus < 0 || plus > at) {
                plus = at;
            }
            StringBuilder builder = new StringBuilder(email.length());
            for (int i = 0; i < plus; i++) {
                char ch = email.charAt(i);
                if (ch != '.') {
                    builder.append(ch);
                }
            }
            builder.append(email, at, email.length());
            unique.add(builder.toString());
        }
        return unique.size();
    }
}
