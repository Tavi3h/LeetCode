package pers.tavish.solution.medium;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

for more information: https://leetcode.com/problems/zigzag-conversion/description/
*/

public class ZigZagConversion {

    @Test
    public void testCase() {
        String string = "A";
        System.out.println(convert(string, 1));
    }

    @SuppressWarnings("unchecked")
    public String convert(String s, int numRows) {
        
        if (numRows == 1) {
            return s;
        }

        List<Character>[] lists = new List[numRows];

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }

        int groupSize = 2 * numRows - 2;

        String[] group = subString(s, groupSize);

        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j < group[i].length(); j++) {
                if (j < numRows - 1) {
                    lists[j].add(group[i].charAt(j));
                } else {
                    lists[groupSize - j].add(group[i].charAt(j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lists.length; i++) {
            for (Character c : lists[i]) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private String[] subString(String s, int len) {

        int slength = s.length();
        
        if (slength <= len) {
            return new String[] { s };
        }

        List<String> list = new LinkedList<>();

        for (int i = 0; i < slength; i += len) {

            String sub = (i + len <= slength) ? s.substring(i, i + len) : s.substring(i, slength);

            list.add(sub);
        }

        return list.toArray(new String[] {});
    }
}
