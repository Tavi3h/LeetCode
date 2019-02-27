package pers.tavish.solution.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]

for more information: https://leetcode.com/problems/repeated-dna-sequences/
*/

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        if (s.length() > 10) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                String sub = s.substring(i, i + 10);
                if (map.containsKey(sub)) {
                    if (map.get(sub) == 1) {
                        map.replace(sub, -1);
                        res.add(sub);
                    }
                } else {
                    map.put(sub, 1);
                }
            }
        }
        return res;
    }

    @Test
    public void testCase() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }
}
