package pers.tavish.solution.easy;

import org.junit.Test;

/*

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:
Input: 1
Output: "1"

Example 2:
Input: 4
Output: "1211"

for more information: https://leetcode.com/problems/count-and-say/description/
*/

public class CountAndSay {
    public String countAndSay(int n) {
        return countAndSay(n, 1, "1");
    }

    private String countAndSay(int n, int times, String s) {

        if (times == n) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            int count = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    count++;
                } else {
                    break;
                }
            }
            sb.append(count);
            sb.append(c);
            i += count;
        }

        return countAndSay(n, times + 1, sb.toString());
    }

    @Test
    public void testCase() {
        System.out.println(countAndSay(10).equals("13211311123113112211"));
    }
}
