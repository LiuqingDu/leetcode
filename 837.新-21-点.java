/*
 * @lc app=leetcode.cn id=837 lang=java
 *
 * [837] 新 21 点
 */

// @lc code=start
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        
        double[] f = new double[n + 1];
        double s = 0;
        for (int i = n; i >= 0; i--) {
            f[i] = i >= k ? 1 : s / maxPts;
            // 当前循环计算的是 f[i+1] + ... + f[i+maxPts]
            // 下个循环计算的是 f[i] + ... + f[i+maxPts-1]，多了 f[i]，少了 f[i+maxPts]
            s += f[i];
            if (i + maxPts <= n) {
                s -= f[i + maxPts];
            }
        }
        return f[0];

    }
}
// @lc code=end

