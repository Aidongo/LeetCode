/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode p0 = dummy;

        while(list1 != null || list2 != null) {
            if(list1 == null) {
                p0.next = list2;
                break;
            }

            if(list2 == null) {
                p0.next = list1;
                break;
            }
        
            if(list1.val > list2.val) {
                p0.next = list2;
                list2 = list2.next;
            }else {
                p0.next = list1;
                list1 = list1.next;
            }
            p0 = p0.next;
        }

        return dummy.next;
    }
}
// @lc code=end

