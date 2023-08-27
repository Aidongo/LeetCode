/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {

    public int quicksort(int[] arr, int l, int r, int k) {
        int pivot = arr[l];
        int i = l;
        int j = r;
        while(i < j) {
            while (i<j && arr[j] <= pivot) j--;
            arr[i] = arr[j];
            while(i<j && arr[i] >= pivot) i++;
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        if(i==k-1) return arr[i];
        else if (i<k-1) return quicksort(arr, i+1, r, k);
        else return quicksort(arr, l, i-1, k);
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quicksort(nums, 0, n-1,k);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,1,2,3,3};
        int k = 2;
        System.out.println(s.findKthLargest(nums, k));
    }
}
// @lc code=end

