/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]) {
                // left ~ mid 是有序区间
                if(target >= nums[left] && target <nums[mid])
                    right = mid - 1;
                else 
                    left = mid + 1;
            }else {
                // mid到right是顺序区间
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else 
                    right = mid - 1;
            }
        }
        return -1;
    }   
}
// @lc code=end

