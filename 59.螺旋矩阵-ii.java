/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {

    // 控制上下左右四个边界，依次填充上下右左的边

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1;
        int i = 1;

        while(i <= n*n) {
            if (up <= down) {
                for (int j = left; j <= right; j++) {
                    res[up][j]=i++;
                }
                up++;
            }
            if (left <= right) {
                for (int j = up; j <= down; j++) {
                    res[j][right]=i++;
                }
                right--;
            }
            if (up <= down) {
                for (int j = right; j >= left; j--) {
                    res[down][j]=i++;
                }
                down--;
            }
            if (left <= right) {
                for (int j = down; j >= up; j--) {
                    res[j][left]=i++;
                }
                left++;
            }
        }
        return res;
        
    }
}
// @lc code=end

