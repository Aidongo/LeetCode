/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    // 回溯
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return res;
        
        used = new boolean[nums.length];
        permuteHelper(nums);
        return res;

    }

    private void permuteHelper(int[] nums){
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
// @lc code=end

