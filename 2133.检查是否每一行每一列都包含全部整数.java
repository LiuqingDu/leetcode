/*
 * @lc app=leetcode.cn id=2133 lang=java
 *
 * [2133] 检查是否每一行每一列都包含全部整数
 */

// @lc code=start
class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            // 使用布尔数组来记录每一行和每一列是否包含1到n的整数
            // 其中row[0]和col[0]不使用
            // row[1]到row[n]和col[1]到col[n]分别表示整数1到n是否出现过
            boolean[] row = new boolean[n + 1];
            boolean[] col = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                row[matrix[i][j]] = true;
                col[matrix[j][i]] = true;
            }
            for (int k = 1; k <= n; k++) {
                // 检查1到n的整数是否都出现过
                if (!row[k] || !col[k]) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

