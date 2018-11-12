package pers.tavish.solution.medium;

import java.util.Arrays;

import org.junit.Test;

/*

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

for more information: https://leetcode.com/problems/next-permutation/description/
*/

public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        
        int i = num.length - 2;
        while (i >= 0 && num[i] >= num[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = i + 1;
            while (j < num.length && num[j] > num[i]) {
                j++;
            }
            j--;
            swap(num, i, j);
        }
        reverse(num, i + 1, num.length - 1);
    }

    // 交换num[i]、num[j]
    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    // 反转num[i]...num[j]
    private void reverse(int[] num, int i, int j) {
        while (i < j) {
            swap(num, i++, j--);
        }
    }

    @Test
    public void testCase() {
        int[] num = { 1, 2, 3, 4, 5, 6 };
        reverse(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }
}
