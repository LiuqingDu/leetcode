/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 */

// @lc code=start
class Solution {
    public int[][] imageSmoother(int[][] img) {
        // 直接暴力对每一个点算平均值是可以的，但时间复杂度比较高
        // 对于一个9格的和，可以用9格的右下角格的二维前缀和 - 左下角的前缀和 - 右上角前缀和 + 左上角前缀和
        // 来计算，二维前缀和就是从左上角到这个点的矩形内的数字之和
        // 而计算每一个格子的前缀和，又可以用前缀和来计算，等于左格子前缀和 + 上格子前缀和 - 左上格子前缀和 + 当前格子数字

        int m = img.length, n = img[0].length;
        // 注意这里前缀和多一层，最左最上一层用来作为起始
        // 表示没有格子的前缀和
        // 真正的img[0][0]的前缀和对应 sumArr[1][1]
        // 注意这里的坐标转换
        // img坐标比sumArr坐标差1
        int[][] sumArr = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 注意下面最后一个img的坐标要-1，因为这里是从sumArr的[1,1]开始的，对应img[0][0]
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m;i ++) {
            for (int j = 0; j < n; j++) {
                // 这里9格的四个角的前缀和可能超出范围，要先处理一下
                int x1 = Math.max(0, i - 1), y1 = Math.max(0, j - 1);
                // 下面的m - 1, n - 1是img也是sum的边界
                // i + 1， j+1是9格的右下角
                int x2 = Math.min(m - 1, i + 1), y2 = Math.min(n - 1, j + 1);
                int count = (x2 - x1 + 1) * (y2 - y1 + 1);
                int sum = sumArr[x2 + 1][y2 + 1] - sumArr[x1 + 1 - 1][y2 + 1] - sumArr[x2 + 1][y1 + 1 - 1] + sumArr[x1 + 1 - 1][y1 + 1 - 1];
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
// @lc code=end

