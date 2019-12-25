import java.util.HashSet;
import java.util.Set;
/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 1.HashSet解法
        // Set<ListNode> set = new HashSet<>();
        // ListNode cur = head;
        // while (cur != null) {
        //     if (set.contains(cur)) {
        //         return cur;
        //     }
        //     set.add(cur);
        //     cur = cur.next;
        // }
        // return null;

        // 2.快慢指针+数学推断
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        ListNode meet = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                meet = fast;
                break;
            }
        }
        if (meet == null) {
            return null;
        }
        while (head != meet) {
            head = head.next;
            meet = meet.next;
        }
        return meet;
    }
}
// @lc code=end

