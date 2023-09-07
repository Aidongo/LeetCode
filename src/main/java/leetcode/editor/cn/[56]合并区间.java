//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2088 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0)
            return new int[0][2];

        // 按照左端点进行排序: 冒泡排序
        intervals = bubbleSort(intervals);

        List<int[]> res = new ArrayList<int[]>();
        for(int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 情况1: 新的数组左端点 > 前一个的右端点r
            if(res.size() == 0 || res.get(res.size()-1)[1] < left) {
                res.add(new int[]{left,right});
            } else {
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],right);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    private int[][] bubbleSort(int[][] arr){
        for(int a = 0; a < arr.length - 1; a++) {
            for(int b = 0; b < arr.length - 1; b++) {
                if(arr[b][0] > arr[b+1][0]) {
                    int tmp1 = arr[b+1][0];
                    int tmp2 = arr[b+1][1];
                    arr[b+1][0] = arr[b][0];
                    arr[b+1][1] = arr[b][1];
                    arr[b][0] = tmp1;
                    arr[b][1] = tmp2;
                }
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
