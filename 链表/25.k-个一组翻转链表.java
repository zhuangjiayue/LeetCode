import java.util.ListResourceBundle;

/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1.k个数组进行遍历
        // ListNode res = new ListNode(0);
        // res.next = head;
        // ListNode outPre = res, cur = head;
        // int count = 0;
        // while (cur != null) {
        //     count++;
        //     // 翻转前保留下一个节点的引用
        //     // 否则，翻转后cur.next会发生变化
        //     cur = cur.next;
        //     if (count % k == 0) {
        //         outPre = reverseList(outPre, cur);
        //     }
            
        // }
        // return res.next;

        // 2.递归
        // ListNode nextHead = head;
        // int count = 0;
        // // 判断是否有k个，没有的话不用翻转直接返回头节点
        // while (count != k) {
        //     if (nextHead == null) {
        //         return head;
        //     }
        //     nextHead = nextHead.next;
        //     count++;
        // }

        // // 翻转链表
        // ListNode cur = head;
        // ListNode pre = null;
        // while (count-- > 0) {
        //     ListNode next = cur.next;
        //     cur.next = pre;
        //     pre = cur;
        //     cur = next;
        // }
        // // 翻转后head为尾节点,head.next为递归返回的头指针
        // head.next = reverseKGroup(nextHead, k);
        // // 此时的pre为翻转后的尾节点
        // return pre;

        // 递归2
        ListNode curr = head;
        int count = 0;
        // 寻找nextHead
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            // curr为后面链表翻转后的头指针
            // 依次翻转链表
            curr = reverseKGroup(curr, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            // 如果翻转了，返回值为curr，此时curr为尾节点
            head = curr;
        }
        return head;
    }

    public ListNode reverseList(ListNode outPre, ListNode end) {
        ListNode firstNode = outPre.next, endNext = end;
        // 定义inPre,inCur两个节点为内部翻转的当前节点和前一个节点
        ListNode inPre = outPre;
        ListNode inCur = firstNode;

        // 翻转内部链表
        while (inCur != end) {
            ListNode next = inCur.next;
            inCur.next = inPre;
            inPre = inCur;
            inCur = next;
        }
        // 处理outPre.next指向inPre（inPre为翻转后的第一个节点）
        outPre.next = inPre;
        // firstNode为翻转后的尾节点，指向end为了保存end的位置
        // 不保存的话，end的引用会丢失
        firstNode.next = end;
        return firstNode;
    }
}
// @lc code=end

