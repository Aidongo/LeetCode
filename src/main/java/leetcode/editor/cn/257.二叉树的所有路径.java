/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();// 存最终的结果
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();// 作为结果中的路径
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        // 中
        paths.add(root.val);
        // 遇到叶子节点
        if(root.left == null && root.right == null) {
            StringBuilder stb = new StringBuilder();
            for(int i = 0; i < paths.size() - 1; i++) {
                stb.append(paths.get(i)).append("->");
            }
            stb.append(paths.get(paths.size()-1));
            res.add(stb.toString());
            return;
        }

        if(root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);
        }

        if(root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);
        }
    }
}
// @lc code=end

