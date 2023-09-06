//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1480 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(matrix == null || matrix.length == 0)
            return res;

        int left = 0;
        int right = cols - 1;
        int top = 0;
        int bottom = rows - 1;
        int eleCount = rows * cols;

        while(eleCount >= 1) {
            for(int i = left; i <= right && eleCount >= 1 ; i++) {
                res.add(matrix[top][i]);
                eleCount--;
            }
            top++;

            for(int i = top; i<= bottom && eleCount >= 1; i++) {
                res.add(matrix[i][right]);
                eleCount--;
            }
            right--;

            for(int i = right; i >= left && eleCount >= 1; i--) {
                res.add(matrix[bottom][i]);
                eleCount--;
            }
            bottom--;

            for(int i = bottom; i >= top && eleCount >= 1; i--){
                res.add(matrix[i][left]);
                eleCount--;
            }
            left++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
