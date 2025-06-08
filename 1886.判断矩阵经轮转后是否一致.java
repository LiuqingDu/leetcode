/*
 * @lc app=leetcode.cn id=1886 lang=java
 *
 * [1886] 判断矩阵经轮转后是否一致
 */

// @lc code=start
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (isSame(mat, target)) return true;
            mat = rotate(mat);
        }
        return false;
    }

    // 判断两个矩阵是否相同
    private boolean isSame(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    // 旋转矩阵90度（顺时针）
    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = mat[i][j];
            }
        }
        return rotated;
    }
}
// @lc code=end

