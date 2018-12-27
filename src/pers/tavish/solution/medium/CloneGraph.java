package pers.tavish.solution.medium;

import java.util.HashMap;
import java.util.Map;

import pers.tavish.struct.UndirectedGraphNode;

/*

Given the head of a graph, return a deep copy (clone) of the graph. Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors. There is an edge between the given node and each of the nodes in its neighbors.


OJ's undirected graph serialization (so you can understand error output):
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 

Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
Note: The information about the tree serialization is only meant so that you can understand error output if you get a wrong answer. You don't need to understand the serialization to solve the problem.

for more information: https://leetcode.com/problems/clone-graph/description/
*/

public class CloneGraph {
    
/*
 * BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        Map<UndirectedGraphNode, UndirectedGraphNode> hashMap = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        
        hashMap.put(node, head);
        queue.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode currNode = queue.poll();
            for (UndirectedGraphNode neighbor : currNode.neighbors) {
                if (!hashMap.containsKey(neighbor)) {
                    queue.add(neighbor);
                    hashMap.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
                hashMap.get(currNode).neighbors.add(hashMap.get(neighbor));
            }
        }
        
        return head;
    }
 */
    // DFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode, UndirectedGraphNode> hashMap = new HashMap<>();
        hashMap.put(node, head);
        dfs(hashMap, node);
        return head;
    }

    private void dfs(Map<UndirectedGraphNode, UndirectedGraphNode> hashMap, UndirectedGraphNode node) {
        
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!hashMap.containsKey(neighbor)) {
                hashMap.put(neighbor, new UndirectedGraphNode(neighbor.label));
                dfs(hashMap, neighbor);
            }
            hashMap.get(node).neighbors.add(hashMap.get(neighbor));
        }
    }
}
