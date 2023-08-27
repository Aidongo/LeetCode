/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 数字排序
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            // 如果第一个元素大于等于0，则直接返回
            if(nums[i] > 0) {
                return res;
            }

            // 去重 a
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            while(right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0) {
                    right --;
                }else if(sum < 0) {
                    left ++;
                }else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重b,c
                    while(right > left && nums[right] == nums[right - 1])   
                        right--;
                    while(right > left && nums[left] == nums[left + 1])
                        left++;

                    right--;
                    left++;
                }
            }
        }
        
        return res;

    }
}
// @lc code=end

