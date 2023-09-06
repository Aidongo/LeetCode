//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1640 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 保留虚拟头
        if(head.next == null || head == null)
            return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre =  dummyHead;
        ListNode end = dummyHead;

        // pre指向left的前一个节点
        for(int i = 0; i < left-1; i++)
            pre = pre.next;

        // end指向right节点
        for(int i = 0; i < right; i++)
            end = end.next;

        // left节点
        ListNode start = pre.next; // [2]
        // right节点的后一个节点
        ListNode latter = end.next; // [5]

        // 切断链表
        pre.next = null;
        end.next = null;

        // 反转中间的链表
        ListNode cur  = start;
        ListNode pr = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pr;
            pr = cur;
            cur = next;
        }

        pre.next = end;
        start.next = latter;

        return dummyHead.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
