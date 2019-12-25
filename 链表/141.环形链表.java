/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.HashSet;
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 解答1：使用集合
        // ListNode cur = head;
        // HashSet<ListNode> hashset = new HashSet<>();
        // while (cur != null) {
        //     if (hashset.add(cur)) {
        //         cur = cur.next;
        //     } else {
        //         return true;
        //     }
        // }
        // return false;

        // 解答2：快慢指针
        if (head == null) return false;
        ListNode fastNode = head, slowNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

