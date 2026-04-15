/*
 * @lc app=leetcode.cn id=3033 lang=java
 *
 * [3033] 修改矩阵
 */

// @lc code=start
class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // 1. 复制矩阵
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = matrix[i][j];
            }
        }
        
        // 2. 每一列找最大值
        for (int j = 0; j < n; j++) {
            int max = -1;
            
            for (int i = 0; i < m; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            
            // 3. 替换 -1
            for (int i = 0; i < m; i++) {
                if (answer[i][j] == -1) {
                    answer[i][j] = max;
                }
            }
        }
        
        return answer;
    }
}
// @lc code=end

