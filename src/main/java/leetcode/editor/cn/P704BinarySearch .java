//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
//
// Related Topics 数组 二分查找 👍 1190 👎 0

package leetcode.editor.cn;
//java:二分查找
class P704BinarySearch{
    public static void main(String[] args){
        Solution solution = new P704BinarySearch().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        /*
        int left = 0;
        int right = nums.length - 1;
        // 判断是否不存在啊
        if(target < nums[left] || target > nums[right])
            return -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
         */

        int left = 0;
        int rifht = nums.length;        // 定义target在左闭右开的区间里，即：[left, right)
        while(left < rifht){            // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
            int mid = (left + rifht) / 2;
            if(target == nums[mid])     // 数组中找到目标值，直接返回下标
                return mid;
            else if(target < nums[mid])
                rifht = mid;            // target 在左区间，在[left, middle)中
            else if(target > nums[mid])
                left = mid + 1;         // target 在右区间，在[middle + 1, right)中
        }
        // 未找到目标值
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}