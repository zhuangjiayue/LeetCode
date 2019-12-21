import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        // 解答1：常规方法
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextNode;
        }
        return pre;

        // 解答2.前向递归
        // head的前一个值为null
        // return reverseCurr(null, head);

        // 解答3：后向递归
        // if (head == null || head.next == null) {
        //     return head;
        // }
        // ListNode p = reverseList(head.next);
        // head.next.next = head;
        // head.next = null;
        // return p;

        // 解答4：栈
        // ArrayDeque<ListNode> deque = new ArrayDeque<ListNode>();
        // ListNode cur = head;
        // while (cur != null) {
        //     deque.push(cur);
        //     cur = cur.next;
        // }
        // ListNode res = null;
        // if (deque.isEmpty()) {
        //     return res;
        // } else {
        //     res = deque.pop();
        // }
        // cur = res;
        // while (!deque.isEmpty()) {
        //     cur.next = deque.pop();
        //     cur = cur.next;
        // }
        // return res;
    }
    // 解答2.前向递归
    // public ListNode reverseCurr(ListNode pre, ListNode curr) {
    //     if (curr == null) {
    //         return pre;
    //     }

    //     ListNode nextNode = curr.next;
    //     curr.next = pre;
    //     return reverseCurr(curr, nextNode); 
    // }
}
// @lc code=end

