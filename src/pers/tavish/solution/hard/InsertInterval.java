package pers.tavish.solution.hard;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pers.tavish.struct.Interval;

/*

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

for more information: https://leetcode.com/problems/insert-interval/description/
*/

public class InsertInterval {
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        if (intervals.isEmpty()) {
            intervals.add(newInterval);
            return intervals;
        }
        
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (newInterval.start < interval.start) {
                intervals.add(i, newInterval);
                break;
            }
            if (i == intervals.size() - 1) {
                intervals.add(newInterval);
                break;
            }
        }
        
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
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
        list.add(new Interval(10, 11));
        list.add(new Interval(15, 2147483647));
        System.out.println(insert(list, new Interval(5,7)));
        System.out.println((0 ^ -1) >>> 31);
    }
}
