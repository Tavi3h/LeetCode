package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]

for more information: https://leetcode.com/problems/restore-ip-addresses/description/
*/

// backtracking
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() >= 4 && s.length() <= 12) {
            restoreIpAddresses(s, res, 0, "");
        }
        return res;
    }

    private void restoreIpAddresses(String s, List<String> res, int start, String sub) {
        if (start == 3 && isValid(s)) {
            res.add(sub + s);
        } else {
            for (int i = 0; i < 3 && i < s.length() - 1; i++) {
                String subStr = s.substring(0, i + 1);
                if (isValid(subStr)) {
                    restoreIpAddresses(s.substring(i + 1, s.length()), res, start + 1, sub + subStr + ".");
                }
            }
        }
    }

    private boolean isValid(String s) {
        return s.charAt(0) == '0' ? s.equals("0") : Integer.parseInt(s) <= 255;
    }

    @Test
    public void testCase() {
        restoreIpAddresses("221221315");
    }
}
