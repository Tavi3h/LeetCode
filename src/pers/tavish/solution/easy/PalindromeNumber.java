package pers.tavish.solution.easy;

import org.junit.Test;

/*

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:
Input: 121
Output: true

Example 2:
Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:
Coud you solve it without converting the integer to a string?

for more information: https://leetcode.com/problems/palindrome-number/description/
*/

public class PalindromeNumber {

    @Test
    public void testCase() {
        System.out.println(isPalindrome(1));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        for (int i = 1, j = sizeOfInt(x); j >= i; i++, j--) {
            if (x / (int) Math.pow(10, j - 1) % 10 != x / (int) Math.pow(10, i - 1) % 10) {
                return false;
            }
        }
        return true;

    }

    private int sizeOfInt(int x) {
        int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };
        for (int i = 0;; i++) {
            if (x <= sizeTable[i]) {
                return i + 1;
            }
        }
    }

//    public boolean isPalindrome(int x) {
//
//        if (x < 0) {
//            return true;
//        }
//
//        int a = 0;
//        int ogx = x;
//
//        while (x != 0) {
//            a = a * 10 + x % 10;
//            x = x / 10;
//        }
//
//        return a != ogx ? false : true;
//
//    }
}
