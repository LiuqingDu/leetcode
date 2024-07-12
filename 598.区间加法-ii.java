/*
 * @lc app=leetcode.cn id=598 lang=java
 *
 * [598] 区间加法 II
 */

// @lc code=start
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        // 可以看出每一个ops都是从坐标0，0开始的一个矩形，
        // 那么坐标0,0的这个点会被所有ops包围，这个点的值就是最大值
        // 那么挨着这个点的都有可能是最大值，这个最大值覆盖面取决于重合度最高的那个区域
        // 在x轴上，ai的最小值就是x轴上重合最多的那个范围，
        // y同理

        for (int i = 0; i < ops.length; i++) {
            m = Math.min(m, ops[i][0]);
            n = Math.min(n, ops[i][1]);
        }
        return m * n;
    }
}
// @lc code=end

