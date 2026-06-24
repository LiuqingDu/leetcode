/*
 * @lc app=leetcode.cn id=835 lang=java
 *
 * [835] 图像重叠
 */

// @lc code=start
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        
        int n = img1.length;
        int maxOverlap = 0;

        // 枚举所有的平移可能
        // rowShift 和 colShift 的范围都是 [-(n-1), n-1]
        for (int rowShift = -(n - 1); rowShift < n; rowShift++) {
            for (int colShift = -(n - 1); colShift < n; colShift++) {
                // 计算当前平移情况下的重叠 1 的数量
                int currentOverlap = countOverlap(img1, img2, rowShift, colShift, n);
                // 维护最大值
                maxOverlap = Math.max(maxOverlap, currentOverlap);
            }
        }

        return maxOverlap;
    }

    // 辅助函数：计算在特定偏移量下，两个图像重叠的 1 的数量
    private int countOverlap(int[][] img1, int[][] img2, int rowShift, int colShift, int n) {
        int count = 0;

        // 遍历 img1 的每一个坐标 (r, c)
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                // 根据相对位移，计算对应的 img2 的坐标 (img2R, img2C)
                int img2R = r + rowShift;
                int img2C = c + colShift;

                // 检查 img2 的坐标是否还在矩阵有效范围内
                if (img2R >= 0 && img2R < n && img2C >= 0 && img2C < n) {
                    // 如果 img1 和 img2 在对应位置都是 1，计数加 1
                    if (img1[r][c] == 1 && img2[img2R][img2C] == 1) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
// @lc code=end

