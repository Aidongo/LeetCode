//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics 递归 链表 👍 1178 👎 0

package leetcode.editor.cn;
//java:移除链表元素
class P203RemoveLinkedListElements{
    public static void main(String[] args){
        Solution solution = new P203RemoveLinkedListElements().new Solution();
    }
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
    public ListNode removeElements(ListNode head, int val) {
        // 单独判断头节点，注意是 while 不是 if
        while(head != null && head.val == val)
            head = head.next;

        // 若链表为空
        if(head == null)
            return head;

        // 确定 head.val != val，判断一般情况
        ListNode pre = head;        // 定义储存上一节点
        ListNode cur = pre.next;
        while(cur != null){
            if(cur.val == val){     // 当前节点为需删除的节点
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}