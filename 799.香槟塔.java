/*
 * @lc app=leetcode.cn id=799 lang=java
 *
 * [799] 香槟塔
 */

// @lc code=start
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // 除了第一个杯子是直接从外部来的,其余杯子都来源于它上层左边和右边的杯子
        // 模拟每一层杯子里的体积,计算出下一层的体积

        double[] row = {poured};
        for (int i = 1; i <= query_row; i++) {
            // 下一行的杯子
            double[] nextRow = new double[i + 1];
            // 遍历当前层每一个杯子
            for (int j = 0; j < i; j++) {
                double volume = row[j];
                // 如果可以溢出,则均分到下一层
                if (volume > 1) {
                    nextRow[j] += (volume - 1) / 2;
                    nextRow[j + 1] += (volume - 1) / 2;
                }
            }
            row = nextRow;
        }
        // min 避免这一杯也可以溢出的情况
        return Math.min(1, row[query_glass]);
    }
}
// @lc code=end

