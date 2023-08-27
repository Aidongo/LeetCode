/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start

import java.util.Random;

class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length == 0)
            return nums; 
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int l, int r) {

        
        if(l < r) {
            randomizePivot(nums, l, r);  // 随机选择主元
            int pos = partition(nums, l, r);
            quickSort(nums, l, pos - 1);
            quickSort(nums, pos + 1, r);
        }
    }

    public static int partition(int[] nums, int l, int r) {
        int pivot = nums[l];

        while(l < r) {
            while(l < r && nums[r] >= pivot) r--;
            if(l < r) {
                nums[l] = nums[r];
                l++;
            }

            while(l < r && nums[l] <= pivot) l++;
            if(l < r) {
                nums[r] = nums[l];
                r--;
            }
        }
        nums[l] = pivot;
        return l;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 随机选择主元并与数组的第一个元素交换
    public static void randomizePivot(int[] nums, int l, int r) {
        Random rand = new Random();
        int randomPivotIndex = l + rand.nextInt(r - l + 1);
        swap(nums, l, randomPivotIndex);
    }
}
// @lc code=end

