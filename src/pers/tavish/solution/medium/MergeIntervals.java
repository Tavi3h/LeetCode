package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import pers.tavish.struct.Interval;

/*

Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

for more information: https://leetcode.com/problems/merge-intervals/
*/

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals.isEmpty()) {
            return intervals;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start == o2.start) {
                    return o1.end - o2.end;
                } else {
                    return 1;
                }
            }
        });

        System.out.println(intervals);

        List<Interval> ans = new ArrayList<>();
        ans.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = ans.remove(ans.size() - 1);
            Interval tmp = intervals.get(i);
            if (hasOverlapping(interval, tmp)) {
                ans.add(mergeInterval(interval, tmp));
            } else {
                ans.add(interval);
                ans.add(tmp);
            }
        }
        return ans;
    }

    private boolean hasOverlapping(Interval i1, Interval i2) {
        int i1s = i1.start, i1e = i1.end;
        int i2s = i2.start, i2e = i2.end;
        return ((i2e - i1s) ^ (i1e - i2s)) >>> 31 == 0;
    }

    private Interval mergeInterval(Interval i1, Interval i2) {
        int start = i1.start > i2.start ? i2.start : i1.start;
        int end = i1.end > i2.end ? i1.end : i2.end;
        return new Interval(start, end);
    }

    @Test
    public void testCase() {
        System.out.println(hasOverlapping(new Interval(15, 2147483647), new Interval(10, 11)));
        System.out.println((2147483637 ^ (-4)) >>> 31);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(10, 11));
        intervals.add(new Interval(15, 2147483647));
        System.out.println(merge(intervals));
    }

}
