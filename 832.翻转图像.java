/*
 * @lc app=leetcode.cn id=832 lang=java
 *
 * [832] 翻转图像
 */

// @lc code=start
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length;
        int n = image[0].length;

        for (int i = 0; i < m; i++) {
            // 注意下面的 ceil((n - 1)/ 2)
            // 是为了在 n 是奇数的时候，遍历前一半且包含最中间的数字
            // 在 n 是偶数的时候，只遍历前一半的数字
            for (int j = 0; j <= Math.ceil((n - 1) / 2); j++) {
                int temp = image[i][j];
                image[i][j] = (image[i][n - 1 - j] + 1) % 2;
                image[i][n - 1 - j] = (temp + 1) % 2;
            }
        }
        return image;
    }
}
// @lc code=end

