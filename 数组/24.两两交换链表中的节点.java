/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 1.递归法
        // if (head == null || head.next == null) return head;
        // ListNode second = head.next;
        // head.next = swapPairs(second.next);
        // second.next = head;
        // return second;

        // 2.遍历法
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        while (pre.next != null && pre.next.next != null) {
            ListNode first = pre.next;
            ListNode second = first.next;
            first.next = second.next;
            pre.next = second;
            second.next = first;
            pre = first;
        }
        return res.next;
    }
}
// @lc code=end

