package pers.tavish.solution.hard;

import java.util.ArrayList;
import java.util.List;

/*

A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).


The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

    - The number of buildings in any input list is guaranteed to be in the range [0, 10000].
    - The input list is already sorted in ascending order by the left x position Li.
    - The output list must be sorted by the x position.
    - There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]

for more information: https://leetcode.com/problems/the-skyline-problem/
*/

public class TheSkylineProblem {

    // divide and conquer 
    public List<int[]> getSkyline(int[][] buildings) {
        return buildings.length == 0 ? new ArrayList<>() : getSkyline(buildings, 0, buildings.length - 1);
    }

    private List<int[]> getSkyline(int[][] buildings, int i, int j) {
        if (i < j) {
            int mid = i + (j - i >>> 1);
            return merge(getSkyline(buildings, i, mid), getSkyline(buildings, mid + 1, j));
        } else {
            List<int[]> res = new ArrayList<>();
            res.add(new int[] { buildings[i][0], buildings[i][2] });
            res.add(new int[] { buildings[i][1], 0 });
            return res;
        }
    }

    private List<int[]> merge(List<int[]> list1, List<int[]> list2) {
        List<int[]> res = new ArrayList<>();
        int h1 = 0, h2 = 0;
        while (list1.size() > 0 && list2.size() > 0) {
            int x = 0, h = 0;
            if (list1.get(0)[0] < list2.get(0)[0]) {
                x = list1.get(0)[0];
                h1 = list1.get(0)[1];
                list1.remove(0);
            } else if (list1.get(0)[0] > list2.get(0)[0]) {
                x = list2.get(0)[0];
                h2 = list2.get(0)[1];
                list2.remove(0);
            } else {
                x = list1.get(0)[0];
                h1 = list1.get(0)[1];
                h2 = list2.get(0)[1];
                list1.remove(0);
                list2.remove(0);
            }
            h = Math.max(h1, h2);
            if (res.size() == 0 || h != res.get(res.size() - 1)[1]) {
                res.add(new int[] {x, h});
            }
        }
        res.addAll(list1);
        res.addAll(list2);
        return res;
    }
}
