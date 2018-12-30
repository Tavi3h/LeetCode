package pers.tavish.solution.hard;

import java.util.HashMap;
import java.util.Map;

/*

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache(2);

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

for more information: https://leetcode.com/problems/lru-cache/description/
*/

public class LRUCache {
    
    private static class DoubleListNode {

        public DoubleListNode prev, next;
        public int key, val;

        public DoubleListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public DoubleListNode(int key, int val, DoubleListNode prev, DoubleListNode next) {
            this(key, val);
            this.prev = prev;
            this.next = next;
        }
    }
    
    private DoubleListNode beginMaker, endMaker;
    private Map<Integer, DoubleListNode> hm;
    private final int CAPACITY;
    
    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        hm = new HashMap<>();
        beginMaker = new DoubleListNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
        endMaker = new DoubleListNode(Integer.MAX_VALUE, Integer.MAX_VALUE, beginMaker, null);
        beginMaker.next = endMaker;
    }
    
    public int get(int key) {
        if (!hm.containsKey(key)) {
            return -1;
        }
        DoubleListNode node = hm.get(key);
        if (node.prev != beginMaker) {
            deleteNode(node);
            moveToHead(node);
        }
        return node.val;
    }
    
    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            DoubleListNode node = hm.get(key);
            node.val = value;
            deleteNode(node);
            moveToHead(node);
        } else {
            if (hm.size() == CAPACITY) {
                DoubleListNode node = endMaker.prev;
                deleteNode(node);
                hm.remove(node.key);
            }
            DoubleListNode node = new DoubleListNode(key, value);
            hm.put(key, node);
            moveToHead(node);
        }
    }

    /* helper */
    private void deleteNode(DoubleListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DoubleListNode node) {
        node.next = beginMaker.next;
        node.next.prev = node;
        beginMaker.next = node;
        node.prev = beginMaker;
    }
    
/*
 * Lazy implementation
    private LinkedHashMap<Integer, Integer> lhm;
    private final int CAPACITY;

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        lhm = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            private static final long serialVersionUID = 648817382308030124L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return lhm.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        lhm.put(key, value);
    }
 */
}
