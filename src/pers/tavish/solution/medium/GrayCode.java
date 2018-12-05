package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

Example 1:
Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1

Example 2:
Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2^n, which for n = 0 the size is 2^0 = 1.
             Therefore, for n = 0 the gray code sequence is [0]. 

for more information: https://leetcode.com/problems/gray-code/description/
*/

public class GrayCode {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }

        List<Integer> result = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        for (int i = result.size() - 1; i >= 0; i--) {
            result.add(addNumber + result.get(i));
        }
        return result;
    }
    
    @Test
    public void testCase() {
        System.out.println(grayCode(4));
    }
}
