//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 965 👎 0

package leetcode.editor.cn;
//java:螺旋矩阵 II
class P59SpiralMatrixIi{
    public static void main(String[] args){
        Solution solution = new P59SpiralMatrixIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int start = 0;//定义每个圈的起始位置
        int loop = 0;       // 每一个圈循环的次数
        int count = 1;      // 定义填充数字，从1开始
        int i,j;
        while(loop++ < n/2){    // 判断边界后，loop从1开始, loop也能作为控制的遍历长度

            // 下面开始的四个for就是模拟转了一圈
            // 模拟填充上行从左到右(左闭右开)
            for(j = start; j < n - loop; j++)
                res[start][j] = count++;

            // 模拟填充右列从上到下(左闭右开)
            for(i = start; i < n - loop; i++)
                res[i][j] = count++;

            // 模拟填充下行从右到左(左闭右开)
            for(; j >= loop; j--)
                res[i][j] = count++;

            // 模拟填充左列从下到上(左闭右开)
            for(; i >= loop; i--)
                res[i][j] = count++;

            // 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
            start++;
        }

        // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
        if (n % 2 == 1)
            res[start][start] = count;

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}