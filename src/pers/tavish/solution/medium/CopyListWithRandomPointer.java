package pers.tavish.solution.medium;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import pers.tavish.struct.RandomListNode;

/*

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

*/

public class CopyListWithRandomPointer {
    
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> hm = new HashMap<>();
        RandomListNode currNew = new RandomListNode(-1), currOld = head;
        while (currOld != null) {
            if (!hm.containsKey(currOld)) {
                hm.put(currOld, new RandomListNode(currOld.label));
            }
            currNew.next = hm.get(currOld);
            currNew = currNew.next;
            currOld = currOld.next;
        }

        for (RandomListNode node : hm.keySet()) {
            hm.get(node).random = hm.get(node.random);
        }

        return hm.get(head);
    }

    @Test
    public void testCase() {
        RandomListNode nodeA = new RandomListNode(1);
        RandomListNode nodeB = new RandomListNode(2);
        RandomListNode nodeC = new RandomListNode(3);
        RandomListNode nodeD = new RandomListNode(4);
        RandomListNode nodeE = new RandomListNode(5);
        RandomListNode nodeF = new RandomListNode(6);
        nodeA.next = nodeB;
        nodeA.random = nodeC;
        nodeB.next = nodeC;
        nodeB.random = nodeA;
        nodeC.next = nodeD;
        nodeC.random = nodeE;
        nodeD.next = nodeE;
        nodeD.random = nodeF;
        nodeE.next = nodeF;
        nodeE.random = null;
        nodeF.next = null;
        nodeF.random = null;
        
        RandomListNode newHead = copyRandomList(nodeA);
        System.out.println(newHead.random.random.label);
    }
}
