package cn.kingen.oj.leetcode.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author Kingen
 **/
public final class MathUtils {

    public static final int MOD = 1_000_000_007;
    public static final Map<Character, Integer> ROMAN_SYMBOLS = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );
    public static final String[] NUMBER_WORDS = {
        "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };
    public static final String[] TEN_NUMBER_WORDS = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    public static char[] ROMAN_NUMBERS = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    public static Map<Character, Integer> PRIORITIES = Map.of(
        '(', 1,
        ')', 1,
        '*', 3,
        '/', 3,
        '%', 3,
        '+', 4,
        '-', 4
    );

    /**
     * Calculate an arithmetic expression.
     *
     * @param s a valid expression with numbers, '+', '-', '*', '/' and brackets
     */
    public static int calculateExpression(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0, len = s.length(); i < len; ) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int j = i, value = 0, c;
                while (j < len && Character.isDigit((c = s.charAt(j)))) {
                    value = value * 10 + c - '0';
                    j++;
                }
                nums.push(value);
                i = j;
            } else {
                if (ch == '(') {
                    ops.push(ch);
                } else if (ch == ')') {
                    while (ops.peek() != '(') {
                        int b = nums.pop(), a = nums.pop();
                        nums.push(applyOperator(ops.pop(), a, b));
                    }
                    ops.pop();
                } else {
                    if ((ch == '+' || ch == '-') && (i == 0 || s.charAt(i - 1) == '(')) { // fill 0 for unary plus/minus
                        nums.push(0);
                    }
                    while (!ops.isEmpty() && ops.peek() != '(' && PRIORITIES.get(ops.peek()) <= PRIORITIES.get(ch)) {
                        int b = nums.pop(), a = nums.pop();
                        nums.push(applyOperator(ops.pop(), a, b));
                    }
                    ops.push(ch);
                }
                i++;
            }
        }
        while (!ops.isEmpty()) {
            int b = nums.pop(), a = nums.pop();
            nums.push(applyOperator(ops.pop(), a, b));
        }
        return nums.pop();
    }

    public static int applyOperator(char operator, int a, int b) {
        return switch (operator) {
            case '+' -> a + b;
            case '*' -> a * b;
            case '-' -> a - b;
            case '/' -> a / b;
            case '%' -> a % b;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }

    /**
     * @return the greatest common divisor of the given two numbers
     */
    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    /**
     * Calculates (p^q)%MOD
     */
    public static long fastPow(long p, long q) {
        return fastPow(p, q, MOD);
    }

    /**
     * Calculates (p^q)%m
     */
    public static long fastPow(long p, long q, long m) {
        long ans = 1;
        while (q > 0) {
            if ((q & 1) == 1) {
                ans = ans * p % m;
            }
            p = p * p % m;
            q >>= 1;
        }
        return ans;
    }

    /**
     * Get all primes less than or equal to n by the sieve of Euler.
     */
    public static List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] notPrimes = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!notPrimes[i]) {
                primes.add(i);
            }
            for (int p : primes) {
                int x = p * i; // next sieved number
                if (x > n) {
                    break;
                }
                notPrimes[x] = true;
                if (i % p == 0) {
                    break;
                }
            }
        }
        return primes;
    }
}
