/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        return getNum(root);
    }

    private int getNum(TreeNode root) {
        if(root == null) return 0;
        int leftNum = getNum(root.left);
        int rightNum = getNum(root.right);
        int treeCount = leftNum + rightNum + 1;
        return treeCount;
    }
}
// @lc code=end

