package pers.tavish.solution.easy;

import org.junit.Test;

/*

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...

Example 1:
Input: 1
Output: "A"

Example 2:
Input: 28
Output: "AB"

Example 3:
Input: 701
Output: "ZY"

for more information: https://leetcode.com/problems/excel-sheet-column-title/description/
*/

public class ExcelSheetColumnTitle {
    
    public String convertToTitle(int n) {
        String alphabet = "ZABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (n <= 26) {
            return Character.toString(alphabet.charAt(n));
        }
        StringBuilder sb = new StringBuilder();
        int m = 0;
        while (n > 26) {
            m = n % 26;
            sb.insert(0, alphabet.charAt(m));
            n /= 26;
            if (m == 0 && n - 1 < 27) {
                break;
            }
        }
        sb.insert(0, m == 0 ? alphabet.charAt(n - 1) : alphabet.charAt(n));
        return sb.toString();
    }

    @Test
    public void testCase() {
        System.out.println(convertToTitle(677));
    }
}
