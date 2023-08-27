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
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode cur = head;
        // 获取链表长度
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        ListNode dummy;
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        
        while(size>=k) {
            size = size - k;

            for(int i = 0; i < k; i ++) {
                end = end.next;
            }

            ListNode start = pre.next;
            ListNode nextHead  = end.next;

            end.next = null;
            pre.next = reverse(start);
            start.next = nextHead;

            pre = start;
            end = pre;
        }
        

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// @lc code=end

