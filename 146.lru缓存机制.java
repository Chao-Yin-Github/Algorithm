import java.util.*;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (46.39%)
 * Likes:    545
 * Dislikes: 0
 * Total Accepted:    52.6K
 * Total Submissions: 110.6K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +'[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) -
 * 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 
 * 
 * 
 * 进阶:
 * 
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 
 * 
 * 示例:
 * 
 * LRUCache cache = new LRUCache( 2 // 缓存容量  );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * 
 * 
 */

// @lc code=start
class LRUCache {
    Map<Integer, Node> map;

    class Node {
        int key;
        int value;
        Node next;
        Node last;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;

    Node head;

    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity * 3 / 2);
        size = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveHead(node);
            System.out.println("get after moveHead");
            print();
            return node.value;
        }
    }

    public void put(int key, int value) {
        // 如果有，更新值并且移动到头部
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveHead(node);
        } else {
            // 如果已经满了，删除尾部
            if (map.size() >= size) {
                System.out.println("size:" + size);
                removeTail();
            }
            // 添加到头部
            System.out.println("size:" + size + map.size());
            Node node = new Node(key, value);
            map.put(key, node);
            node.next = head;
            if (head == null) {
                tail = node;
            } else {
                head.last = node;
            }
            head = node;
        }
        System.out.println("put");
        print();
    }

    private void moveHead(final Node node) {
        if (tail == head || node == head) {
            return;
        }
        Node next = node.next;
        Node before = node.last;
        if (next != null) {
            next.last = before;
        }
        node.next = head;
        if (before != null) {
            before.next = next;
        }
        node.last = null;
        if (head != null) {
            head.last = node;
        }
        head = node;
        if (node == tail) {
            tail = before;
        }
    }

    private void removeTail() {
        if (tail == null) {
            return;
        }
        map.remove(tail.key);
        if (tail.last != null) {
            tail.last.next = null;
            tail = tail.last;
            if (tail.next != null) {
                tail.next.last = null;
            }
        } else {
            tail = null;
        }
        System.out.println("LRUCache.removeTail()");
        print();
    }

    private void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.key + " " + temp.value);
            if (temp == tail) {
                System.out.println("tail");
            }
            temp = temp.next;
        }
        if (tail != null) {
            System.out.println("tail.value" + tail.key + " " + tail.value);
            if (tail.last != null) {
                System.out.println("tail.last.value" + tail.last.key + " " + tail.last.value);
                if (tail.last.next != null) {
                    System.out.println("tail.last.next.value" + tail.last.next.key + " " + tail.last.next.value);
                }
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end