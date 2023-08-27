/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int len_r = grid.length;
        int len_c = grid[0].length;
        int res = 0;
        for(int r = 0; r < len_r; r++) {
            for(int c = 0; c < len_c; c++) {
                if(grid[r][c] == '1') {
                    res++;
                    dfs(grid, r, c);
                }
            }
        }
        return res;
    }

    void dfs(char[][] grid, int r, int c) {
        int len_r = grid.length;
        int len_c = grid[0].length;

        if( r < 0 || c < 0 || r>=len_r || c>=len_c || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r  + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
// @lc code=end

