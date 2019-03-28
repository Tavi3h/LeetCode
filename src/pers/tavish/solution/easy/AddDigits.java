package pers.tavish.solution.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.

Follow up:

    - Could you do it without any loop/recursion in O(1) runtime?

for more information: https://leetcode.com/problems/add-digits/description/
*/

public class AddDigits {
    
    // without loop
    public int addDigits(int num) {
        return num == 0 ? 0 : (num - 1) % 9 + 1;
    }
    
    // with loop
//    public int addDigits(int num) {
//        while (num > 9) {
//            int n = 0;
//            while (num != 0) {
//                n += num % 10;
//                num /= 10;
//            }
//            num = n;
//        }
//        return num;
//    }
    
    @Test
    public void testCase() {
        assertEquals(3, addDigits(138));
    }
}
