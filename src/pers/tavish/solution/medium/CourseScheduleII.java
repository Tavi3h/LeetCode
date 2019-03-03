package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:
Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .

Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

Note:

    - The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    - You may assume that there are no duplicate edges in the input prerequisites.

*/

public class CourseScheduleII {
    
    // DFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjLists = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            adjLists.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjLists.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onVisitingPath = new boolean[numCourses];
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(adjLists, stack, visited, onVisitingPath, i);
            }
        }

        if (stack.size() != numCourses) {
            return new int[] {};
        } else {
            int[] res = new int[numCourses];
            for (int i = 0; i < res.length; i++) {
                res[i] = stack.pop();
            }
            return res;
        }
    }

    private void dfs(List<List<Integer>> adjLists, LinkedList<Integer> stack, boolean[] visited,
            boolean[] onVisitingPath, int curr) {

        visited[curr] = true;
        onVisitingPath[curr] = true;
        for (int vertex : adjLists.get(curr)) {
            if (onVisitingPath[vertex]) {
                return;
            }
            if (!visited[vertex]) {
                dfs(adjLists, stack, visited, onVisitingPath, vertex);
            }
        }
        onVisitingPath[curr] = false;
        stack.push(curr);
    }
    
    // Kahn
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//
//        List<List<Integer>> adjLists = new ArrayList<>();
//        for (int i = 0; i < numCourses; ++i) {
//            adjLists.add(new ArrayList<>());
//        }
//
//        int[] inDegrees = new int[numCourses];
//        for (int[] prerequisite : prerequisites) {
//            adjLists.get(prerequisite[1]).add(prerequisite[0]);
//            ++inDegrees[prerequisite[0]];
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < inDegrees.length; i++) {
//            if (inDegrees[i] == 0) {
//                queue.add(i);
//            }
//        }
//
//        int[] res = new int[numCourses];
//        int pos = 0;
//        while (!queue.isEmpty()) {
//            int course = queue.remove();
//            for (int vertex : adjLists.get(course)) {
//                if (--inDegrees[vertex] == 0) {
//                    queue.add(vertex);
//                }
//            }
//            res[pos++] = course;
//        }
//
//        return pos == numCourses ? res : new int[] {};
//    }


    @Test
    public void testCase() {
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        System.out.println(Arrays.toString(findOrder(4, prerequisites)));
    }
}
