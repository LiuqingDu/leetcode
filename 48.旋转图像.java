/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        // 先沿左上右下的对角线翻转，再左右翻转就是顺时针90°旋转

        for (int i = 0; i < matrix.length; i++) {
            // 注意对角线翻转只需要遍历整个矩形的一半就可以，如果全遍历了就是翻过去又翻回来，没变化
            // 所以这里初始 j=i 而不是j=0，只遍历j大于i的部分，也就是半个矩形
            for (int j = i; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 左右翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = tmp;
            }
        }
    }
}
// @lc code=end

